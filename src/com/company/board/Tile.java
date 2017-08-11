package com.company.board;

import com.company.Ships.Ship;

public abstract class Tile {

    private final int m_tileCoordinate;


    Tile(final int tileCoordinate) {
        this.m_tileCoordinate = tileCoordinate;
    }

//    private static final Map<Integer,EmptyTile> EMPTY_TILE_MAP_CACHE = createEmptyBoard();
//
//    private static Map<Integer, EmptyTile> createEmptyBoard(){
//        final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();
//        for (int i = 0; i < GameUtility.NUM_TILES; i++){
//            emptyTileMap.put(i, new EmptyTile(i));
//        }
//        return ImmutableMap.copyOf(emptyTileMap);
//    }
//
//    public static Tile createTile(final int tileCoordinate){
//        return EMPTY_TILE_MAP_CACHE.get(tileCoordinate);
//    }
//    FOR VISUAL BOARD IN FUTURE

    public abstract boolean isTileOccupied();

    public abstract Ship getShip();

    public final class EmptyTile extends Tile {

        EmptyTile(int tileCoordinate) {
            super(tileCoordinate);
        }

        @Override
        public boolean isTileOccupied() {
            return false;
        }

        @Override
        public Ship getShip() {
            return null;
        }
    }

    public final class OccupiedTile extends Tile {

        private final Ship m_shipOnTile;

        public OccupiedTile(final int tileCoordinate, final Ship shipOnTile) {
            super(tileCoordinate);
            this.m_shipOnTile = shipOnTile;
        }

        @Override
        public boolean isTileOccupied() {
            return true;
        }

        @Override
        public Ship getShip() {
            return m_shipOnTile;
        }
    }
}
