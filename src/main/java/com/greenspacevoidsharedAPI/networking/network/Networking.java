package com.greenspacevoidsharedAPI.networking.network;

import com.esotericsoftware.kryo.Kryo;

import com.greenspacevoidsharedAPI.networking.network.messages.gameEntity.NetworkedEntity;
import com.greenspacevoidsharedAPI.networking.network.messages.login.NetworkedLogin;

import java.util.ArrayList;

public class Networking {






    /*
     * The {@code Network} class handles basic setup logic for {@link Server} and {@link Client} communication



        /**
         * Registers every class needed to send a and the messages themselves.
         * The order of registration must be the same on each {@link EndPoint}, and
         * so it is handled in a common dependency.
         * <br>
         * DEV NOTE: Keep the order of registration in alphabetical order
         */
    public static void syncRegisters(Kryo kryo){


        kryo.register(ArrayList.class);
        kryo.register(byte[].class);
        kryo.register(NetworkedLogin.CLIENT.CLIENT_SEND_LoginMessage.class);
        kryo.register(NetworkedLogin.CLIENT.CLIENT_RECEIVE_LoginStatusMessage.class);
        kryo.register(NetworkedEntity.class);
        kryo.register(NetworkedEntity.CLIENT_RECEIVE.AddEntitiesMessage.class);
        kryo.register(NetworkedEntity.CLIENT_RECEIVE.FullEntityRefreshMessage.class);
        kryo.register(NetworkedEntity.CLIENT_RECEIVE.UpdateEntitiesMessage.class);
        kryo.register(NetworkedEntity.CLIENT_RECEIVE.RemoveEntitiesMessage.class);

        /*
        kryo.register(ArrayList.class);
        kryo.register(LoginMessage.class);
        kryo.register(LoginStatusMessage.class);
        kryo.register(MoveShipToMessage.class);
        kryo.register(ObjectData.class);
        kryo.register(ObjectVariants.class);
        kryo.register(RegistrationMessage.class);
        kryo.register(RegistrationStatusMessage.class);
        kryo.register(UpdateRenderedObjectsMessage.class);
        */


    }
}



