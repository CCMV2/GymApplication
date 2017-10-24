package com.ubb.gymapp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name = "rooms")
@SequenceGenerator (sequenceName = "room_seq", allocationSize = 1, name = "roomSeq")
public class Room implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3276612315392966807L;

	private long roomId;
	
	private String roomName;

	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "roomSeq")
	@Column (name = "idroom", unique = true, nullable = false)
	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}
	
	@Column (name = "name")
	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (roomId ^ (roomId >>> 32));
		result = prime * result + ((roomName == null) ? 0 : roomName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		if (roomId != other.roomId)
			return false;
		if (roomName == null) {
			if (other.roomName != null)
				return false;
		} else if (!roomName.equals(other.roomName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomName=" + roomName + "]";
	}
	
	
}
