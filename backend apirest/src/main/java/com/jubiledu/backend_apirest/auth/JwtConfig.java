package com.jubiledu.backend_apirest.auth;

public class JwtConfig {
    public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";

    public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\n" +
            "MIIEpQIBAAKCAQEApq7RHxxpZRgt4pF/A0Y6stN8C4qzBcEtZ68rCJe3HFqDmn8n\n" +
            "PJ2Z364QhQWLaCTJsobpk5vgeg8yZZ1i9hiKGrOhStxFVJa93SJrLB33oNu6arZ1\n" +
            "B+ixsUMVcViVrE02CEuwnCWPa5XYEYgnJ9v9VRwi6Pf0pAPAaMJXn9N/GezCY8PZ\n" +
            "UItvlAn07R0O0btbA71ITS8qDaC5MduutKXa3tZlv+/AzrsieMCE/RCuQyOLYNkl\n" +
            "bnO5eBF4G/TPScLO8JiV/zxix7Uy7nAgV46PJywL4NLcTlsHhiWkJaoWcBrOaruH\n" +
            "wQWOWnb5tABv7uhNkWHQgPUbtHu8+j7AgJ2OYQIDAQABAoIBAAr8FF4Hgk6eRE/d\n" +
            "JNCzbSTh2RftoRStAXAG1EAxt2iP8oJZBN3yyPQ7xWzuy5wmaIBycaw/ppCEtd6K\n" +
            "e74aKefOlL+ZOpxzfrm3DfcPVoVsVaG4uoe15xf2gtBAdUSwpfHwAwiXVRdS/bVS\n" +
            "ErqGvfBA9XAC/0Vb1e9Rd3LZ/lNX8tDBPMrQ3qfPLWgZkmnFBue2uUm7A3lyDZ77\n" +
            "yYKxfpx5kzbGA4RObNRcdgAdZEile4Ff7kE96Fwf2tGrIEo8xc3yTKsnhQKlGuvx\n" +
            "5vqDJHLS1YWs7R8UUbLUBtHTDm23kmsljN9YBAuKmng3e0RNJiFZbwqy0rEyZbtE\n" +
            "hmW1XVECgYEA0ajHWRjsKA8TdrYCzMqjP+5acVHnSIGqw2QhxAMLVozQg99aiLKi\n" +
            "Svmgy8QnpLrdbE/3AgeKk2Y4oAMMB324egKjK3nPq4tSCLzOs0HdWbIewuYlxOOg\n" +
            "T3UPhGqdLeRS2LKXtRGcBkPnxAx5aa9TZ2BerhP5nKJU1nMbipJWC+0CgYEAy4ZK\n" +
            "HbPRsVc2ypoHyypGtrDDN7Ap/szkh6wYIautDR/OxuMtajxYUKnIgvQSNVUxyB72\n" +
            "5+G299W7RTAWmdbD2owm7o3y5mhNQm79ERGJM65aJEJPgvARRU42kTAfNW++tIkj\n" +
            "aC2NQAnWKKAAruSSrjVORPlZTWYi7vbpQvT9xcUCgYEAnyH7BQ5cmN8wh8cIgwY/\n" +
            "OJQig6aF5Mu+oAWNd2hUH8JLtfw+jEkB0+R6/o6JBIhs7fwX4Kt2rABHdHQ7mif7\n" +
            "cGg2Dxaq4GqjvkwIm5ifeKgwnv/upO2czRJtz7TYTm/hzeZoLaALC9pYvL43HVdc\n" +
            "97b2xiwVJqUzvX2q5tfBhdUCgYEAl1lmBHCUn6ybsk6ZPRxTOch5ZBA9Kp5z0/DG\n" +
            "gUOJjRj6TCzkuPvnMRURZ1DZuY+BVbCxK/9OcT8f5HO+Wui6/Or8iKpG19D4o06m\n" +
            "IutHfIdLwWsOdfDQ5xkiuxVuH+7Zgqf5DJ/TSqwF9nAGEgkoiyRY8DH9lvE9STeU\n" +
            "f5ZwoYECgYEAtz4WBYZalFQUQ+E7ZqPnS0e+A3FcGTbcZStro4b2IlG1q0Yl9UUc\n" +
            "rVRe++OGpFjFC7u3Iy+uksjs0qNWa+PC12Vv5hCTPqKE1JEunpJ0Z5jQoLpnJKww\n" +
            "oesYiPp+eWDa08T08zmW76Kct7tYQRTdLAikJT+huLCP5I75e8Si7GY=\n" +
            "-----END RSA PRIVATE KEY-----";

    public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApq7RHxxpZRgt4pF/A0Y6\n" +
            "stN8C4qzBcEtZ68rCJe3HFqDmn8nPJ2Z364QhQWLaCTJsobpk5vgeg8yZZ1i9hiK\n" +
            "GrOhStxFVJa93SJrLB33oNu6arZ1B+ixsUMVcViVrE02CEuwnCWPa5XYEYgnJ9v9\n" +
            "VRwi6Pf0pAPAaMJXn9N/GezCY8PZUItvlAn07R0O0btbA71ITS8qDaC5MduutKXa\n" +
            "3tZlv+/AzrsieMCE/RCuQyOLYNklbnO5eBF4G/TPScLO8JiV/zxix7Uy7nAgV46P\n" +
            "JywL4NLcTlsHhiWkJaoWcBrOaruHwQWOWnb5tABv7uhNkWHQgPUbtHu8+j7AgJ2O\n" +
            "YQIDAQAB\n" +
            "-----END PUBLIC KEY-----";
}
