@echo off

REM Windows script for running karma tests
REM You have to run server and capture some browser first
REM
REM Requirements:
REM - NodeJS
REM - Karma (npm install -g karma)
REM Maybe you need install
REM - requirejs (npm install -g requirejs)
REM - karma-requirejs (npm install -g karma-requirejs)
REM - karma-jasmine (npm install -g karma-jasmine)
REM - karma-cli (npm install -g karma-cli)
REM - jasmine-core (npm install -g jasmine-core)
REM - angular-mocks (npm install -g angular-mocks)

set BASE_DIR=%~dp0
karma start "%BASE_DIR%\..\config\karma.config.js" %*