#!/bin/bash

# Mini maintenance script for keeping common Vipps API files updated.
# Christian Løverås, cl@vipps.no

# Directory with all the "vipps-XXX-api" repositories.
main_dir=/Users/cl/Dev

# End of "configuration"
# --------------------------------------------------

# Where are we now?
start_dir=`pwd`

# Home, sweet home
cd $main_dir

# Find the API repositories: "vipps-XXX-api"
api_dirs=$(ls -d vipps*api)

# Fix stuff
for api_dir in $api_dirs ; do
    cd $api_dir

    echo "$api_dir"

    git checkout -q master
    echo "git branch: master"

    # pull
    git pull

    # Update CONTRIBUTING.md
    echo 'cp ../vipps-api-common/CONTRIBUTING.md .'
    cp ../vipps-api-common/CONTRIBUTING.md . ;
    git add CONTRIBUTING.md ;

    # Update LICENSE
    echo 'cp ../vipps-api-common/LICENSE .'
    cp ../vipps-api-common/LICENSE . ;
    git add LICENSE ;

    # If no README.md: Copy the template
    if [ ! -f README.md ]; then
      echo 'cp ../vipps-api-common/README-template.md README.md'
      cp ../vipps-api-common/README-template.md README.md
      git add README.md
    fi

    # Commit and push to GitHub
    git commit -m 'Updated with API standard' ;
    git push ;

    # Back to start
    cd $main_dir
    echo

done

# Back to reality
cd $start_dir
