# DoAnCK_Mobile
# Hướng dẫn sử dụng git: (dùng cmd để sử dụng các câu lệnh)
- Đối với lần đầu sử dụng (AN, Thảo Trang, My) thì cần "clone" project từ trên git xuống (tức là kéo folder code từ git xuống máy mình)
  + Sử dụng lệnh: git clone https://github.com/PhatNguyen1736/DoAnCK_Mobile.git
- Sau đó mở folder vừa clone lên, tạo các folder chứa code của mình rồi đặt tên folder là Project_AnhNguyen/Project_My/Project_ThaoTrang
- Sau đó mỗi người "di chuyển" vào project tương ứng rồi code trong đó
  + Sử dụng lệnh: cd Project_AnhNguyen
- Khi đã code xong, theo các bước sau để "push" code lên git (đẩy code trong máy mình lên lại github)
  + git add .
  + git commit -m "Noi dung thay doi (ghi ngan thoi, ko can ghi dai lam gi)"
  + git push origin master
- Mỗi khi có thay đổi trên git, mà muốn update folder trong máy mình giống với trên git.
  Thì ta cần "pull" code từ trên git xuống.
  + Đi vào folder cha chứa Project_Phat: cd Project_FoodOrder
  + Sử dụng lệnh: git pull origin master
- Lặp lại gạch đầu dòng thứ 3 và thứ 4 cho đến khi qua môn!
