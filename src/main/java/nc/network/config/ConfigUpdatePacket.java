package nc.network.config;

import io.netty.buffer.ByteBuf;
import nc.config.NCConfig;
import nc.util.NCUtil;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class ConfigUpdatePacket implements IMessage {
	
	protected boolean messageValid;
	
	public boolean radiation_enabled;
	
	public ConfigUpdatePacket() {
		messageValid = false;
	}
	
	public ConfigUpdatePacket(boolean radiation_enabled) {
		this.radiation_enabled = radiation_enabled;
		
		messageValid = true;
	}
	
	public void readMessage(ByteBuf buf) {
		radiation_enabled = buf.readBoolean();
	}
	
	public void writeMessage(ByteBuf buf) {
		buf.writeBoolean(radiation_enabled);
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		try {
			readMessage(buf);
		} catch (IndexOutOfBoundsException ioe) {
			NCUtil.getLogger().catching(ioe);
			return;
		}
		messageValid = true;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		if (!messageValid) return;
		writeMessage(buf);
	}
	
	public static class Handler implements IMessageHandler<ConfigUpdatePacket, IMessage> {
		
		@Override
		public IMessage onMessage(ConfigUpdatePacket message, MessageContext ctx) {
			if (!message.messageValid && ctx.side != Side.CLIENT) return null;
			Minecraft.getMinecraft().addScheduledTask(() -> processMessage(message));
			return null;
		}
		
		protected void processMessage(ConfigUpdatePacket message) {
			NCConfig.onConfigPacket(message);
		}
	}
}
