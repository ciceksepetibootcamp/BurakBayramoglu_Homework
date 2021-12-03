Bu projede 15 adet Discord API'si Postman ile test edilmiştir.

**Gereksinimler**

- İki adımlı doğrulama kapalı Discord üyeliği
- Postman

**Kurulum ve Kullanım**

- DISCORD.postman_collection.json dosyasısı Postman'da içe aktarılır.
- Environments kısmından yeni bir değişken tablosu oluşturulur.
- Aşağıda belirtilen değişkenler tek tek eklenir.

* mail (current value -> Discord veritabanına giriş yapılacak mail adresi ile düzenlenir)
* password (current value -> Discord veritabanına giriş yapılacak mail adresi ile düzenlenir)
* token
* parent_id
* channelid (current value -> Discord uygulaması üzerinden ilk mesajın gönderileceği kanalın ID'si bulunmalıdır. Yardım için: https://support.discord.com/hc/tr/articles/206346498-Kullan%C4%B1c%C4%B1-Sunucu-Mesaj-ID-sini-Nerden-Bulurum- )
* lastmsgid
* channel_name
* new_channelid
* guildid
* newguildid

- Gerekli değişkenler ayarlandıktan sonra oluşturulan çevre değişkenleri seçilir ve aktarılmış DISCORD koleksiyonu teste hazır hale gelir.

**Test Adımları**

Login Testi -> Mail ve password bilgisi kullanılarak Login requesti gönderilir. Başarılı durumlarda 200 Status Code döndürür. Sonraki işlemlerimizde kullanacağımız Token değişkeni Set edilir.

Mesaj Gönderme Testi -> Belirtilen channelid'ye "This is a test message" mesajı gönderilir. Başarılı durumlarda 200 Status Code döndürür. Sonraki işlemlerde kullanılacak olan son mesaj değişkeni Set edilir.

Son Mesaj Düzenleme Testi -> Gönderilen "This is a test message" mesajını "This is an edited message." olarak değiştirir.

Son Mesaja Tepki Ekleme Testi -> Düzenlenmiş olan son mesaja "👍" tepkisini ekler.

Mesajdan Tepki Kaldırma Testi -> Mesajdan eklenmiş olan "👍" tepkisini kaldırır.

Son Mesaja Yanıt Testi -> Son mesaja "This is a reply message." şeklinde bir yanıt verir. Değişkenlerde yeni son mesaj olarak tanımlanır ve daha sonra kullanılmak üzere katagori ID'si set edilir (guild_id)

Son Mesajı Sabitleme Testi -> Son mesajı sabitler.

Sabitleme Kaldırma Testi -> Sabitlemeyi kaldırır.

Son Mesajı Silme Testi -> Değişkenlerde ayarlanmış olan son mesaj silinir.

Yeni Kanal Oluşturma Testi -> "testchannel{1-100 arasında rastgele sayı}" Şeklinde yeni bir kanal oluşturur. "new_channelid" değişkeni daha sonra kullanılmak üzere set edilir.

Yeni Kanala Mesaj Gönderme Testi -> Oluşturulan yeni kanala "new_channelid" değişkeni kullanılarak "This the first message of our newest channel :smile: !" mesajı gönderilir.

Yeni Kategori Oluşturma Testi -> "testCategory" adında bir kategori oluşturur. "newguildid" değişkeni daha sonra kullanılmak üzere set edilir.

Yeni Kategorinin İsmini Düzenleme Testi -> Oluşturulan kategorinin ismi "newguildid" değişkeni kullanılarak "New Category Name" olarak değiştirilir.

Yeni Oluşturulan Kategorinin Altında Sesli Kanal Oluşturma Testi ->  "newguildid" değişkeni kullanılarak az önce oluşturup ismini değiştirdiğimiz kategoriye bağlı "NewVoiceChannel" isminde bir sesli kanal oluşturulur.

Yeni Rol Oluşturma Testi -> Mor renkli, diğer üyelerden ayrı gözüken "New Admin Role" adında bir rol oluşturur.


Yukarıda belirttiğim Requestlere ait Body'ler düzenlenebilir. Örneğin :

Yeni Rol Oluşturma Testinde kullanılan {"name": "New Admin Role","color": "10181046", "hoist": true} bodysinde isim, renk (10'luk taban) ve ayrıcalık (boolean) gibi pek çok Request düzenlenebilmektedir. Aşağıda bulunan GIF'te Postman ile yapılan koşumu görebilirsiniz.

![GIF](https://i.imgur.com/2jbtQkU.gif)
