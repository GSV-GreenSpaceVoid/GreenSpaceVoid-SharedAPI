package com.greenspacevoidsharedAPI.networking.network.messages.gameEntity;

import com.greenspacevoidsharedAPI.networking.network.messages.SharedMessage;
import com.greenspacevoidsharedAPI.networking.renderer.EntityIndex;
import com.greenspacevoidsharedAPI.networking.renderer.AnimationStates;

import java.util.ArrayList;
import java.util.Date;

public class NetworkedEntity{//Object Class. Data networking classes are nested in this file.



    //Entity

    public String entityIDString; //THIS NUMBER IS SINGLE HANDEDLY THE MOST IMPORTANT OF THEM ALL! It unifies the data between
    //server and client without using fixed-size arrays.
    public EntityIndex model;
    public String name;


    //Renderer specific info
    public boolean isRendered;//<-Imagine this variable as being the dividing line of the forest and the trees that make up the forest
    //"I can't see the asteroid field because the asteroids are in the way!:"
    public double x,y,direction, distance;


    //UI Specific info
    public boolean hasHealthPool, isTargetable, distanceInAUs;; //IMPORTANT: So that we do NOT render what doesn't need to be rendered.
    public double currentShield, maxShield, currentHealth, maxHealth, currentHull, maxHull;



    //X and Y work off of a server-processed local origin. Yes, the server can do everything. Better more CPU work on server
    //than loss of bandwidth sending over big, unintelligible coordinates. 2 numbers are better than 4.

    public NetworkedEntity(){
        super();
        //Best we leave this empty or else...
    }
    ///////////

    public static class NetworkedVessel extends NetworkedEntity{

        boolean isIndestructible;

        public NetworkedVessel(){

        }






    }






    public static class CLIENT_RECEIVE {


        public static class AddEntitiesMessage extends SharedMessage{
            public ArrayList<NetworkedEntity> entities = new ArrayList<>();
            public AddEntitiesMessage(){
                super();

            }
        }

        public static class FullEntityRefreshMessage extends SharedMessage{
            ArrayList<NetworkedEntity> entities = new ArrayList<>();
            //Functions as a complete repaint
            public FullEntityRefreshMessage() {
                super();
            }
        }

        public static class RemoveEntitiesMessage extends SharedMessage{
            public ArrayList<String> ids = new ArrayList<>();
            public RemoveEntitiesMessage(){
                super();
            }
        }

        public static class UpdateEntitiesMessage extends SharedMessage{
            public ArrayList<NetworkedEntity> entities = new ArrayList<>();
            public UpdateEntitiesMessage(){
                super();

            }
        }

        public static class TargetSpecificDataMessage extends SharedMessage{
            //Currently unused.
            //Leave this as an empty stub
            public TargetSpecificDataMessage(){
                super();
            }
        }


        //IF WE CAN OVERRIDE DATA TO SAVE BANDWIDTH, MORE POWER TO US. Todo: Test kryonet and see which serializes better.
        public static class UpdateHitPointPoolsMessage extends SharedMessage{
            int index;
            double currentShield, maxShield, currentHealth, maxHealth, currentHull, maxHull;

            public UpdateHitPointPoolsMessage(){
                super();
            }
        }

        public static class UpdateAnimationStateMessage extends SharedMessage{
            int index;
            AnimationStates primaryAnimationState;
            AnimationStates secondaryAnimationState;


        }

    }

    public static class CLIENT_SEND{


        public static class RequestTargetSpecificData extends SharedMessage{

            public RequestTargetSpecificData(){
                super();
            }

        }


        public static class RequestRefreshMessage extends SharedMessage{
            Date date = new Date();
            public RequestRefreshMessage(){
                super();
            }
        }



















    }








    //To Client:







}
