Conniption
==========

The missing TradeKing API for Java.

## Getting an API Key from TradeKing

* [Visit the Tradeking Developers Website](https://developers.tradeking.com/applications/)  
  * [Fill in their info and you will get 4 important values needed for OAuth](http://oauth.net/)
  * An API Key
  * An API Secret Key
  * An Access Token
  * A Secret Access Token

## Installing

To avoid putting these OAuth keys in the code base, and do avoid config files. TradeKingForeman uses ForemanConstants convience methods.
They all access System environment variables (via System.getEnv()). The following lines should be added to your environment variables.

### Linux

Put these lines in /etc/environment.

    API_KEY=<YOUR API KEY HERE>
    API_SECRET=<YOUR API SECRET HERE>
    ACCESS_TOKEN=<YOUR ACCESS TOKEN HERE>
    ACCESS_TOKEN_SECRET=<YOUR SECRET ACCESS TOKEN HERE>


### Mac

Put these lines in /etc/launchd.conf

    setenv API_KEY <YOUR API KEY HERE>
    setenv API_SECRET <YOUR API SECRET HERE>
    setenv ACCESS_TOKEN <YOUR ACCESS TOKEN HERE>
    setenv ACCESS_TOKEN_SECRET <YOUR SECRET ACCESS TOKEN HERE>
    
    
Restart your computer.

## Usage



## Warnings



## License, Attribution, etc
