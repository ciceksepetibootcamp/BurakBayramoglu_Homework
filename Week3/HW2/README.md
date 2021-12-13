Cucumber BDD


Maven ile oluşturulan bu projemde Selenium, JUnit ile Monsternotebook.com sitesi üzerinde Cucumber frameworku kullanılarak 3 adet senaryo test edilmiştir.

TEST 1 -> Başarılı giriş ardından sepete ürün ekleme testi

monsternotebookbdd.feature dosyası içerisinde yer alan değişkenler kullanılarak giriş yapılır, <itemname> değişkeni aratılır ve çıkan ilk sonuç sepete ekleyebilmelidir.
  
TEST 2 -Z Başarılı giriş ardından geçersiz arama testi
  
monsternotebookbdd.feature dosyası içerisinde yer alan değişkenler kullanılarak giriş yapılır, <itemname> değişkeni aratılır. Bu değişken feature dosyasında geçersiz kelime veya rastgele karakterler olarak ayarlanmıştır. Arama sonucunda kullanıcı geçersiz arama yaptığı ile ilgili bilgilendirildiği bir sayfa ile karşılaşmalıdır.
 
TEST 3-Z Başarısız giriş testi
  
monsternotebookbdd.feature dosyası içerisinde yer alan değişkenler kullanılarak giriş yapılmaya çalışılır. Girilen bilgiler geçersiz olacağından kullanıcı anasayfaya yönlendirilmeyecektir ve bulunduğu sayfada "Giriş Yap" butonunu tekrar görüntülemelidir. Böylece geçersiz giriş yapıldığı anlaşılmalıdır.
