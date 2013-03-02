package MineFluence.com.ioniancupcake.common.worldgen;
 
import java.util.Random;

import MineFluence.MineFluence;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
 
public class MineFluenceWorldGenerator implements IWorldGenerator{
 
        public void generate(Random random, int chunkX, int chunkZ, World world,  IChunkProvider chunkGenerator, IChunkProvider chunkProvider){
               
               
                switch(world.provider.dimensionId){
               
                case -1: generateNether(world, random, chunkX*16, chunkZ*16);
                case 0: generateSurface(world, random, chunkX*16, chunkZ*16);
               
                }
        }
       
       
        public void generateSurface(World world, Random random, int chunkX, int chunkZ){
        	Random rand = new Random();        	
        	for (int i = 0; i < 5; i++) 
        	{
                int randPosX = chunkX + rand.nextInt(16);
                int randPosY = rand.nextInt(64);
                int randPosZ = chunkZ + rand.nextInt(16);
                        
                (new WorldGenMinable(MineFluence.oreIod.blockID, 10)).generate(world, rand,
                		randPosX, randPosY, randPosZ);
        	}
        	
        
        
        
        	for (int i = 0; i < 10; i++) 
    		{
        		int randPosX = chunkX + rand.nextInt(16);
        		int randPosY = rand.nextInt(64);
        		int randPosZ = chunkZ + rand.nextInt(16);
                    
        		(new WorldGenMinable(MineFluence.oreTin.blockID, 10)).generate(world, rand,
            		randPosX, randPosY, randPosZ);
    		}
        }
       
        public void generateNether(World world, Random random, int blockX, int blockZ){
               
               
               
        }
       
       
       
}