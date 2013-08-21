package com.robsonp.wallet.util;

import java.util.UUID;

public class UniqueSha256Hash {

    private String uniqueHash;
    
    public UniqueSha256Hash() {
        uniqueHash = Encripter.sha256(UUID.randomUUID().toString());
    }

    @Override
    public String toString() {
        return uniqueHash;
    }

    
}
