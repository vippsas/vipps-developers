import logging
import os

OS_PATH = os.path.dirname(__file__)
LOGDIR = os.path.join(OS_PATH, 'logs')


def get_logger(facility, logfile='debug.log'):
    """
    Creates a logger function based on the logging library
    :param facility:    Name of what's calling logger.
    :param logfile:     File to log to (default: 'debug.log')
    :return:
    """
    # create logger
    log_instance = logging.getLogger(facility)

    log_instance.setLevel(logging.DEBUG)
    # create file handler which logs even debug messages
    if not os.path.exists(LOGDIR):
        os.makedirs(LOGDIR)
    fh = logging.FileHandler(os.path.join(LOGDIR, logfile), encoding="UTF-8")
    fh.setLevel(logging.DEBUG)
    # create console handler with a higher log level
    ch = logging.StreamHandler()
    ch.setLevel(logging.ERROR)
    # patch the default logging formatter to use unicode format string
    logging._defaultFormatter = logging.Formatter(u"%(message)s")
    # create formatter and add it to the handlers
    formatter = logging.Formatter(u'%(asctime)s - %(name)s - %(levelname)s - %(message)s')
    fh.setFormatter(formatter)
    ch.setFormatter(formatter)
    # add the handlers to the logger
    log_instance.addHandler(fh)
    log_instance.addHandler(ch)

    return log_instance


def log_request(facility, headers=None, body=None, response=None):
    logger = get_logger(facility)
    # if headers:
    # logger.info("Headers: {}".format(head
    if body:
        logger.info("Body: {}".format(body))
    if response:
        logger.info("Response: {}".format(response))
    return


def log_callback(facility, callback_msg=None, return_msg=None, path_var=None):
    logger = get_logger(facility)
    if path_var:
        logger.info("Path var: {}".format(path_var))
    if callback_msg:
        logger.info("Callback message: {}".format(callback_msg))
    if return_msg:
        logger.info("Return Message: {}".format(return_msg))
    return
