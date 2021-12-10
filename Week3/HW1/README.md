# REST ASSURED MOVIES

Bu projede Java Rest Assured kullanılarak themoviedb.org sitesine ait 5 adet API testi yapılmıştır. Projeyi çalıştırmak için gerekli Maven üzerinden dependency'ler kurulmalıdır. Gerekli Dependency'lere POM.XML dosyasından ulaşabilirsiniz.

Gerekli kurulumları yaptıktan sonra projeyi çalıştırmak için API Key'e ihtiyacınız bulunmakta. The Movie DB sitesine ait API Keyizi https://www.themoviedb.org/settings/api adresinden giriş yaparak API Anahtarı (v3 auth) başlığı altında bulabilirsiniz.


TEST SENARYOLARI : 

1 - Request Token Oluşturma (createRequestToken) Endpoint : /authentication/token/new
2 - Login Requesti (loginRequest) Endpoint : /authentication/token/validate_with_logi
3 - Rating Kıyaslama Testi (goodRatedMovieTest) Endpoint: /movie/{integer}
4 - En İyi 3. Dizi Testi (checkTheThirdTopRatedTVSeriesName) Endpoint : /tv/top_rated
5 - Janra Validasyon Testi (checkGenres) Endpoint : /genre/movie/list


TEST ADIMLARI 

Requestlerde kullanılan syntax -> (Base_URL+EndPoint+"?=api_key=" + API_KEY)

createRequestToken :

- Request atmak üzere URL set edilir ve GET metodu ile Request atılır.
- Response status kodu 200 olup olmadığı kontrol edilir.
- Response Body'sindeki success değerinin True olup olmadığı kontrol edilir.
- Response'den veri almak için response extract edilir.
- Login Requestinde kullanmak üzere request.token kaydedilir.
- request_token değişkeni set edilir.

loginRequest :

- Post Request atmak üzere Body Json formatında set edilir. (User,password,request_token değişkenleri)
- JSON formatında veri ile Post metodu kullanarak request atılır. 

