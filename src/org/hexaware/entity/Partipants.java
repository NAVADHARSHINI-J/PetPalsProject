package org.hexaware.entity;

public class Partipants {
	private int participantId;
	private String participantName;
	private String participantType;
	private String eventId;
	public Partipants(int participantId, String participantName, String participantType, String eventId) {
		super();
		this.participantId = participantId;
		this.participantName = participantName;
		this.participantType = participantType;
		this.eventId = eventId;
	}
	public int getParticipantId() {
		return participantId;
	}
	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}
	public String getParticipantName() {
		return participantName;
	}
	public void setParticipantName(String participantName) {
		this.participantName = participantName;
	}
	public String getParticipantType() {
		return participantType;
	}
	public void setParticipantType(String participantType) {
		this.participantType = participantType;
	}
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	
}
