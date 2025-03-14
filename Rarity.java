public enum Rarity {
    COMMON, GREAT, RARE, EPIC, LEGENDARY;

    public Rarity getNextRarity() {
        switch (this) {
            case COMMON:
                return GREAT;
            case GREAT:
                return RARE;
            case RARE:
                return EPIC;
            case EPIC:
                return LEGENDARY;
            default:
                return null;
        }
    }
}
