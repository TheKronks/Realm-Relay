package realmrelay.data;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;


public class AllyShootPacket extends Packet {
	
	public static final byte ID = 92;
	
	public int bulletId;
	public int ownerId;
	public short containerType;
	public float angle;

	@Override
	public byte id() {
		return ID;
	}

	@Override
	public void parseFromInput(DataInput in) throws IOException {
		this.bulletId = in.readUnsignedByte();
		this.ownerId = in.readInt();
		this.containerType = in.readShort();
		this.angle = in.readFloat();
	}

	@Override
	public void writeToOutput(DataOutput out) throws IOException {
		out.writeByte(this.bulletId);
		out.writeInt(this.ownerId);
		out.writeShort(this.containerType);
		out.writeFloat(this.angle);
	}

}
