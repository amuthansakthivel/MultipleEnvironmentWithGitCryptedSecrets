Enabling git crypt to maintain secrets :

[Setup Guide](https://dev.to/heroku/how-to-manage-your-secrets-with-git-crypt-56ih)

**GPG with Git Crypt :**

1. Generate and Share your GPG Key

Install gpg on your system:

macOS (with homebrew): brew install gnupg

Linux or Windows WSL: sudo apt install gnupg

Follow these directions from [GitHub](https://docs.github.com/en/authentication/managing-commit-signature-verification/generating-a-new-gpg-key) to generate a new gpg key.
   
Your key should begin with 

-----BEGIN PGP PUBLIC KEY BLOCK----- and end with -----END PGP PUBLIC KEY BLOCK-----

if it doesn't you have the wrong data!

Share your public key with someone whose key has already been added and ask them to complete Step II below:


2. (Existing User) 

 Add the New User to git-crypt

 These steps can be completed by anyone whose gpg key has been added and who has Maintain permissions or higher.

Save the public key you receive as newkey.asc.

Run gpg --import newkey.asc to import the key into your local gpg instance.

Run gpg --list-keys and make note of the key's ID (will be a string of 40 hex characters) and email address.

Run gpg --edit-key <KEY_ID> to open the gpg console (source):

Type trust to edit the key's trust level

Type 5 to indicate you trust the key and then y.

Type quit to exit the gpg console.

Double-check to ensure that you're on the branch you want to commit the change in permissions to.

Run git-crypt add-gpg-user <USER_EMAIL_ADDRESS> to add the new user to git-crypt.

The changes will automatically be committed, but you must run git push to push them to remote.