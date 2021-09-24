package br.com.brdev2w.authenticationservice.utils;

import java.util.UUID;

public class UUIDGenerator {

	 public String UUIDGen(){
	 	UUID uuid =  UUID.randomUUID();
	 	String s = uuid.toString();

	 	return s;

	 }
}
