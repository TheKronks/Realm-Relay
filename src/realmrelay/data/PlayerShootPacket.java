package realmrelay.data;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;


public class PlayerShootPacket extends Packet {
	
	public static final byte ID = 90;
	
	public int time;
	public int bulletId;
	public int containerType;
	public Location startingPos = new Location();
	public float angle;

	@Override
	public byte id() {
		return ID;
	}

	@Override
	public void parseFromInput(DataInput in) throws IOException {
		this.time = in.readInt();
		this.bulletId = in.readUnsignedByte();
		this.containerType = in.readUnsignedShort();
		this.startingPos.parseFromInput(in);
		this.angle = in.readFloat();
	}

	@Override
	public void writeToOutput(DataOutput out) throws IOException {
		out.writeInt(this.time);
		out.writeByte(this.bulletId);
		out.writeShort(this.containerType);
		this.startingPos.writeToOutput(out);
		out.writeFloat(this.angle);
	}

}
