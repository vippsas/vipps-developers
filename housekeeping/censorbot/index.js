/**
 * Import libraries
 */

const { SlackAdapter } = require('botbuilder-adapter-slack');

/**
 * Define a function for initiating a conversation on installation
 * With custom integrations, we don't have a way to find out who installed us, so we can't message them :(
 */

function onInstallation(bot, installer) {
    if (installer) {
        bot.startPrivateConversation({user: installer}, function (err, convo) {
            if (err) {
                console.log(err);
            } else {
                convo.say('I am a bot that has just joined your team');
                convo.say('You must now /invite me to a channel so that I can be of use!');
            }
        });
    }
}


/**
 * Configure the persistence options
 */

var config = {};
if (process.env.MONGOLAB_URI) {
    var BotkitStorage = require('botkit-storage-mongo');
    config = {
        storage: BotkitStorage({mongoUri: process.env.MONGOLAB_URI}),
    };
} else {
    config = {
        json_file_store: ((process.env.TOKEN)?'./db_slack_bot_ci/':'./db_slack_bot_a/'), //use a different name if an app or CI
    };
}

/**
 * Are being run as an app or a custom integration? The initialization will differ, depending
 */

if (process.env.TOKEN || process.env.SLACK_TOKEN) {
    //Treat this as a custom integration
    var customIntegration = require('./lib/custom_integrations');
    var token = (process.env.TOKEN) ? process.env.TOKEN : process.env.SLACK_TOKEN;
    var controller = customIntegration.configure(token, config, onInstallation);
} else if (process.env.CLIENT_ID && process.env.CLIENT_SECRET && process.env.PORT) {
    //Treat this as an app
    var app = require('./lib/apps');
    var controller = app.configure(process.env.PORT, process.env.CLIENT_ID, process.env.CLIENT_SECRET, config, onInstallation);
} else {
    console.log('Error: If this is a custom integration, please specify TOKEN in the environment. If this is an app, please specify CLIENTID, CLIENTSECRET, and PORT in the environment');
    process.exit(1);
}

// Handle events related to the websocket connection to Slack
controller.on('rtm_open', function (bot) {
    console.log('** The RTM api just connected!');
});

controller.on('rtm_close', function (bot) {
    console.log('** The RTM api just closed');
    // you may want to attempt to re-open
});

// Greetings from Censorbot
controller.on('bot_channel_join', function (bot, message) {
    bot.reply(message, "I'm here!");
});

/**
 * Event listeners
 */

// Look for social security number or account number
controller.hears('\\d(.{0,2}\\d){10}', ['direct_mention', 'mention', 'direct_message', 'message_received', 'ambient'], function(bot, message) {

	/* If there are multiple numbers in the message, trim() will remove whitespaces in the string
	 * and look for the number with 11 digits
	 */
	var removeWhitespace = message.text.trim()
	var number = removeWhitespace.match(/\d(.{0,2}\d){10}/).toString()

  // Strip all non-numeric characters from {number}
	var strippedNumber = number.replace(/\D/g,'')

	// Check if the number is either a social security number or a bank account number
  var socialSecurityNumber = birthNumber(strippedNumber)
  var accountNumber = validateAccountNumber(strippedNumber)

  
	// If at least one of the statements is true the bot will reply to the user
  if(socialSecurityNumber === true || accountNumber === true ){
    var response = ':warning: *Friendly reminder:* Et nummer i meldingen ser ut som et `fødselsnummer` eller `kontonummer`. Hvis det er nødvendig å poste sensitiv persondata i Slack, vurder å sende dette i en _privat_ melding.'
    bot.reply(message, response)
  }
});

/**
 * Functions
 */

// Validate account number
var validateAccountNumber = function (accountNumber) {

    if (!accountNumber) {
        return false;
    }

    if (accountNumber.length !== 11) {
        return false;
    }

    return parseInt(accountNumber.charAt(accountNumber.length - 1), 10)
            === mod11OfNumberWithControlDigit(accountNumber);
};

// Validate social security number
var birthNumber = function(birthNumber){

    var _sum = function(birthNumber, factors){
        var sum = 0;
        for(i = 0, l = factors.length; i < l; ++i){
            sum += parseInt(birthNumber.charAt(i),10) * factors[i];
        }
        return sum;
    };

    var checksum1 = 11 - (_sum(birthNumber, [3, 7, 6, 1, 8, 9, 4, 5, 2]) % 11);
    if (checksum1 === 11) checksum1 = 0;
    var checksum2 = 11 - (_sum(birthNumber, [5, 4, 3, 2, 7, 6, 5, 4, 3, 2]) % 11);
    if (checksum2 === 11) checksum2 = 0;
      return checksum1 === parseInt(birthNumber.charAt(9), 10) && checksum2 === parseInt(birthNumber.charAt(10), 10);
};

// Modulus11 check
var mod11OfNumberWithControlDigit = function (input) {
    var controlNumber = 2,
        sumForMod = 0,
        i;

    for (i = input.length - 2; i >= 0; --i) {
        sumForMod += input.charAt(i) * controlNumber;
        if (++controlNumber > 7)
            controlNumber = 2;
    }
    var result = (11 - sumForMod % 11);

    return result === 11 ? 0 : result;
};
