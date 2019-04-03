package jcs.testproject.cachesystem;

import org.apache.commons.jcs.JCS;
import org.apache.commons.jcs.access.CacheAccess;
import org.apache.commons.jcs.access.exception.CacheException;

public class MusicStore {

	private static MusicStore instance;
	private static int checkedOut = 0;
	private static CacheAccess<Integer, Album> testCache;
	
	private MusicStore() {
		
		try {
			testCache = JCS.getInstance("testCache");
			
			//initialize the cache
			testCache.put( new Integer(1), new Album( 1, "Toby Mac", "Diverse City" ) );
			testCache.put( new Integer(2), new Album( 2, "Pillar", "Fireproof" ) );
			testCache.put( new Integer(3), new Album( 3, "Audio Adrenaline", "Underdog" ) );
			
			System.out.println("STATS AT STARTUP");
			System.out.println("testCache.getStatistics().getStatElements().size()" + testCache.getStatistics().getStatElements());
	        System.out.println("testCache.getStatistics().getAuxiliaryCacheStats()" + testCache.getStatistics().getAuxiliaryCacheStats());
	        System.out.println("END STATS AT STARTUP");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//inizializzare le altre mappe se necessario
	}
	
	
	
	public void addAlbum( Album album )
    {
        try
        {
        	testCache.put( album.getId(), album );
        	
        }
        catch( CacheException e )
        {
            e.printStackTrace();
        }
    }

    public Album getAlbum( Integer id )
    {
        return ( Album )testCache.get( id );
    }

    public void removeAlbum( Integer id )
    {
        try
        {
        	testCache.remove( id );
        }
        catch( CacheException e )
        {
            e.printStackTrace();
        }
    }

    public static void main( String[] args )
    {
        MusicStore musicStore = new MusicStore();
        musicStore.addAlbum( new Album( 4, "The O.C. Supertones", "Supertones Strike Back" ) );
        musicStore.addAlbum( new Album( 5, "The Rolling Stones", "Supertones Strike Back" ) );
        musicStore.addAlbum( new Album( 6, "The Beatles", "Yellow Submarine" ) );
        musicStore.addAlbum( new Album( 7, "The Claudios", "UmpaLumpa Song" ) );
        musicStore.addAlbum( new Album( 8, "Mario Merola", "Amaro Merola" ) );
        musicStore.addAlbum( new Album( 9, "Gigi D'alessio", "Giggino" ) );
        musicStore.addAlbum( new Album( 10, "Nino D'angelo", "Napoli" ) );
        musicStore.addAlbum( new Album( 11, "Ruggero dei Timidi", "Notte Romantica" ) );
        musicStore.addAlbum( new Album( 12, "Davide van der Sfroos", "La balera" ) );
        musicStore.addAlbum( new Album( 13, "Elio e le Storie tese", "Servi della Gleba" ) );
        musicStore.addAlbum( new Album( 14, "Gem Boy", "OrgiaCartoon" ) );
        
        System.out.println("STATS AT POPULATION");
        System.out.println("testCache.getStatistics().getStatElements().size()" + testCache.getStatistics().getStatElements());
        System.out.println("testCache.getStatistics().getAuxiliaryCacheStats()" + testCache.getStatistics().getAuxiliaryCacheStats());
        System.out.println("END STATS AT POPULATION");
        
        Album album = musicStore.getAlbum( 1 );
        System.out.println( "Album 1: " + album );
        album = musicStore.getAlbum( 2 );
        System.out.println( "Album 2: " + album );
        album = musicStore.getAlbum( 4 );
        System.out.println( "Album 4: " + album );
        album = musicStore.getAlbum( 6 );
        System.out.println( "Album 6: " + album );
        album = musicStore.getAlbum( 8 );
        System.out.println( "Album 8: " + album );
        album = musicStore.getAlbum( 10 );
        System.out.println( "Album 10: " + album );
        album = musicStore.getAlbum( 11 );
        System.out.println( "Album 11: " + album );
        album = musicStore.getAlbum( 12 );
        System.out.println( "Album 12: " + album );
        album = musicStore.getAlbum( 13 );
        System.out.println( "Album 13: " + album );
        album = musicStore.getAlbum( 14 );
        System.out.println( "Album 14: " + album );
        musicStore.removeAlbum( 4 );
        album = musicStore.getAlbum( 4 );
        System.out.println( "Album 4: " + album );
        
        System.out.println("STATS BEFORE END");
        System.out.println("testCache.getStatistics().getStatElements().size()" + testCache.getStatistics().getStatElements());
        System.out.println("testCache.getStatistics().getAuxiliaryCacheStats()" + testCache.getStatistics().getAuxiliaryCacheStats());
        System.out.println("END STATS BEFORE END");
        
    }
}
