#!/usr/bin/env bash

cd target/classes
wsgen -verbose -keep -cp . com.percyvega.cxf.HelloWorldImpl -wsdl
