package petermacdonald.valorgmcompanion.character;

import android.support.annotation.NonNull;

/**
 * Created by peter on 2017-07-02.
 */

public abstract class CharacterComponent implements Comparable<CharacterComponent> {
    protected final String name;
    protected String subtitle;
    protected final boolean subtitleable;
    protected final int season;
    protected final boolean multiplesAllowed;
    protected int level;

    protected CharacterComponent(String name, boolean subtitleable, int season, boolean multiplesAllowed) {
        this.name = name;
        this.subtitleable = subtitleable;
        this.multiplesAllowed = multiplesAllowed;
        this.season = season;
        this.level = 1;
        this.subtitle = null;
    }

    protected CharacterComponent(String name, boolean subtitleable, int season, boolean multiplesAllowed, int level) {
        this.name = name;
        this.subtitleable = subtitleable;
        this.multiplesAllowed = multiplesAllowed;
        this.season = season;
        this.level = level;
        this.subtitle = null;
    }

    public CharacterComponent(String name, String subtitle, boolean subtitleable, int season, boolean multiplesAllowed) {
        this.name = name;
        this.subtitle = subtitle;
        this.subtitleable = subtitleable;
        this.season = season;
        this.multiplesAllowed = multiplesAllowed;
        this.level = 1;
    }

    public CharacterComponent(String name, String subtitle, boolean subtitleable, int season, boolean multiplesAllowed, int level) {
        this.name = name;
        this.subtitle = subtitle;
        this.subtitleable = subtitleable;
        this.season = season;
        this.multiplesAllowed = multiplesAllowed;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public int getSeason() {
        return season;
    }

    public boolean isMultiplesAllowed() {
        return multiplesAllowed;
    }

    public int getLevel() {
        return level;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isSubtitleable() {
        return subtitleable;
    }

    @Override
    public int compareTo(@NonNull CharacterComponent o) {
        return name.compareTo(o.name);
    }
}
