package com.hv.ecommerce.common;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Utils {
    public static Timestamp getCurrentTimestamp() {
        ZonedDateTime nowAsiaSingapore = ZonedDateTime.now().withZoneSameInstant(ZoneId.of("Asia/Saigon"));
        Timestamp createdDate = Timestamp.valueOf(nowAsiaSingapore.toLocalDateTime());
        return createdDate;
    }
}
