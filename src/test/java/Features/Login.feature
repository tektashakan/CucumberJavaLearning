

  Feature: Login Senaryoları
    @login
    Scenario: Login işlemleri
      Given Login sayfası açılır
      When Kullanıcı adı girilir
      And Şifre bilgisi girilir
      And Login buton tıklanır
      Then Login ana ekranı açılır