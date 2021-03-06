package realmrelay.data;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;


public class InvitedToGuildPacket extends Packet {
	
	public static final byte ID = 85;
	
	public String name;
	public String guildName;

	@Override
	public byte id() {
		return ID;
	}

	@Override
	public void parseFromInput(DataInput in) throws IOException {
		this.name = in.readUTF();
		this.guildName = in.readUTF();
	}

	@Override
	public void writeToOutput(DataOutput out) throws IOException {
		out.writeUTF(this.name);
		out.writeUTF(this.guildName);
	}

}
