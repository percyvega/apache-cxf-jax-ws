#!/usr/bin/env bash

cd target/classes
wsimport -verbose -keep HelloWorldImplService.wsdl
