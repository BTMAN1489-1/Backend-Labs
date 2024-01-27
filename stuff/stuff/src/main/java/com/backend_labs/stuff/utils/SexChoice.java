package com.backend_labs.stuff.utils;

import java.util.List;

public class SexChoice {
	private SexChoice(){}
	public static String Male = "male";
	public static String Female = "female";
	public static String Unknown = "unknown";

	public static List<String> getChoices(){
		return List.of(SexChoice.Female, SexChoice.Unknown, SexChoice.Male);
	}
}
