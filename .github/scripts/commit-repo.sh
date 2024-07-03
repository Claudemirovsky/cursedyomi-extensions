#!/bin/bash
set -e

rsync -a --delete --exclude .git --exclude .gitignore --exclude .gitattributes --exclude repo.json ../master/repo/ .
git lfs install
git config --global user.email "$BOT_EMAIL"
git config --global user.name "$BOT_NAME"
git status
if [ -n "$(git status --porcelain)" ]; then
    git add .
    MSG="Update extensions repo"
    if [[ $(git log -1 --pretty=format:%s) =~ "$MSG" ]]; then
      git commit --amend --no-edit
      git push --force
    else
      git commit -m "$MSG"
      git push
    fi
else
    echo "No changes to commit"
fi
