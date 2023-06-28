package com.etsuni.globalreputation.utils;

import java.util.UUID;

public class Reputation {

    public UUID uuid;

    public Long reputationPoints;

    public Reputation(UUID uuid, Long reputationPoints) {
        this.uuid = uuid;
        this.reputationPoints = reputationPoints;
    }
}
