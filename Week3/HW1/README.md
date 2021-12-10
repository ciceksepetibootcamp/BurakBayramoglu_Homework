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
- Status kodu 200 olup olmadığı kontrol edilir.



goodRatedMovieTest :

- 2 adet film id'si oluşturmak için for döngüsü ile "i" değişkeni oluşturulur. Oluşturulan i değişkeni Endpoint içerisinde kullanılarak request atılır.
- Status kodu 200 olup olmadığı kontrol edilir.
- Response Body'sindeki "vote_averate" değerinin 5.0'dan büyük olup olmadığı kontrol edilir.
- Sonuç {Film adı} --> {Puan} şeklinde konsola basılır.



checkTheThirdTopRatedTVSeriesName:

- Request atmak üzere URL set edilir ve GET metodu ile Request atılır.
- Status kodu 200 olup olmadığı kontrol edilir.
- Response Body'sindeki üçüncü elemanın değerinin "Arcane: League of Legends" olup olmadığı kontrol edilir.



checkGenres :

- Request atmak üzere URL set edilir ve GET metodu ile Request atılır.
- Status kodu 200 olup olmadığı kontrol edilir.
- Response Body'sindeki ilk elemanın değerinin "Action" olup olmadığı kontrol edilir.
- Response Body'sindeki son elemanın değerinin "Western" olup olmadığı kontrol edilir.
- Responsenin elde edilmesinin 4 saniyeden daha az sürüp sürmediği test edilir.
