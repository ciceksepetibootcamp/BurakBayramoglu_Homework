# Burak Bayramoğlu Homework

# Ankara İli İçin Yapılan Yorumlar Listesi
![image](https://user-images.githubusercontent.com/13181041/147655401-6594f63c-1cf6-46d0-b16d-3632255f7d52.png)

Testler
- Response Code 200

Yapılmış tüm yorumlar üzerinden;
- Yorumlar listesinin büyüklüğünün 6
- Name değerinin String
- Comment değerinin String
- Rating değerinin Number
- createOn değerinin String
- cityName değerinin String
- Ve cityName değerinin Query Param ile eşitliği kontrol edilmiştir. Ankara ili için yapılan testte mock datada bulunan son yorumdaki cityName değeri Hatay olduğundan assertion fail olmaktadır.

# İstanbul İli İçin Yapılan Yorumlar Listesi
![image](https://user-images.githubusercontent.com/13181041/147656197-8275f4cb-6249-4ab4-baf2-8f74c1aa169e.png)

Testler
- Response Code 200

Yapılmış tüm yorumlar üzerinden;
- Yorumlar listesinin büyüklüğünün 6
- Name değerinin String
- Comment değerinin String
- Rating değerinin Number
- createOn değerinin String
- cityName değerinin String
- Ve cityName değerinin Query Param ile eşitliği kontrol edilmiştir.

# 404 Not Found Testi (Van)

![image](https://user-images.githubusercontent.com/13181041/147656323-1dcb1df9-ef4b-4341-b82e-cdccc71b49b4.png)

Testler
- Response Code 404
- Dönen body'deki message'nin "Not Found" stringine eşit olup olmadığı

# 400 Null Param Testi

![image](https://user-images.githubusercontent.com/13181041/147656574-fdf61e13-1dd3-4614-8cec-0f9fd46f57ab.png)

Testler
- Response Code 400
- Dönen body'deki cityName'nin "'cityName' can not be null." stringine eşit olup olmadığı

kontrolleri sağlanmıştır.
