package demoqa.dataBuilders;

public class PersonalInformationObjectMothers {
	public static PersonalInformation getDennisTaylor() {
		return PersonalInformationBuilder.runtimeBuilder()
					.withFirstName("Dennis")
					.withLastName("Taylor")
					.withGender("Male")
					.build();
	}
	
	public static PersonalInformation getWaiChan() {
		return PersonalInformationBuilder.runtimeBuilder()
					.withFirstName("Wai")
					.withLastName("Chan")
					.withGender("Male")
					.build();
	}
	
	public static PersonalInformation getJaneDoe() {
		return PersonalInformationBuilder.runtimeBuilder()
					.withFirstName("Jane")
					.withLastName("Doe")
					.withGender("Female")
					.build();
	}
}