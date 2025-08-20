package model;

public enum StateGallows {
    ZERO(" \n\n\n\n\n\n"),
    ONE("  O \n\n\n\n\n"),
    TWO("  O \n  | \n\n\n\n"),
    THREE("  O \n /| \n\n\n"),
    FOUR("  O \n /|\\ \n\n\n"),
    FIVE("  O \n /|\\ \n / \n\n"),
    SIX("  O \n /|\\ \n / \\ \n\n\n");

    private final String gallows;

    StateGallows(String gallows) {
        this.gallows = gallows;
    }

    public String getGallows() {
        return gallows;
    }
}

