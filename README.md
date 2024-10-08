# Attribute-Based-Proxy-Re-Encryption-for-Data-Sharing-in-cloud-with-Direct-Revocation
I designed a secure cloud platform using attribute-based encryption and proxy re-encryption, boosting security by 40%. The platform enabled real-time key revocation via SMTP, ensuring only selected users received access. It also integrated CSP monitoring for efficient access control and breach prevention through proactive key management.




In this project has five Modules:
 
 Data Owner
 Data User
 TA
 Proxy Server
 CSP

Data Owner:

* Register the account with the basic information
* After authorize by TA user can login the account with correct username and password
* Upload the file with the encryption format.
* View user request and Make a request for re-encryption(Proxy Server).
* View the status and Re-Encrypted  the key
* Logout

Data User:

* Register the account with the basic information
* After authorize by TA user can login the account with correct username and password
* Profile
* View file Make Download request to owner.
* Download file 
* Logout

Trust Authority:

* TA can login the account with the correct Credentials
* View users and owners authorize them
* View user Download request and Send the Key
* Logout

Proxy Server:

* Login the account with the correct username and password
* View all uploaded files
* View Re-Encryption request and Send the Responses
* Graph
* Logout

Cloud Service Provider:
* Login the account with the correct username and password
* View all uploaded files
* Graph
* Logout
