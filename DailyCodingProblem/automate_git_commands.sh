#!/bin/sh
#Bash Script Automation
#Automating GIT Commands (Add, Commit, Push)
##################################
currentDirectory = $1
gitCommitMessage = "(insert commit message)"
echo Entering Directory: $1
cd $1
echo "$commitString"
#Switch to the branch you want to use
git checkout master
#add all new / modified files
git add .
#commit changes
git commit -m "$gitCommitMessage"
#push to git remote repository
git push
##########
echo "Press Enter"
read 
