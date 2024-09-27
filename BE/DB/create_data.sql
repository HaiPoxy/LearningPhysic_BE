INSERT INTO Course(	course_name, 	`description`, 	  price, 	is_free,  class_level,   image_url,   created_at,    updated_at ) 
VALUES
					('Vật lý 12 CTST', 'Vật lý 12'	,	2  , FALSE	,  12 , 'abc'  , '2023-03-05', '2023-03-05' ),
					('Vật lý 11 CTST', 'Vật lý 11'	,	2  , FALSE	,  11 , 'abc'  , '2023-03-05', '2023-03-05' ),
					('Vật lý 10 CTST', 'Vật lý 10'	,	2  , FALSE	,  10 , 'abc'  , '2023-03-05', '2023-03-05' ),
					('Vật lý 9 CTST' , 'Vật lý 9'	,	2  , FALSE	,  9  , 'abc'  , '2023-03-05', '2023-03-05' ),
					('Vật lý 8 CTST' , 'Vật lý 8'	,	2  , FALSE	,  8  , 'abc'  , '2023-03-05', '2023-03-05' ),
					('Vật lý 7 CTST' , 'Vật lý 7'	,	2  , FALSE	,  7  , 'abc'  , '2023-03-05', '2023-03-05' ),
					('Vật lý 6 CTST' , 'Vật lý 6'	,	2  , FALSE	,  6  , 'abc'  , '2023-03-05', '2023-03-05' );
					   
INSERT INTO Lesson(course_id, 	 chapter_name, 	  lesson_name, 	created_at,  updated_at ) 
VALUES
					(1   , 	'Vật lí nhiệt'   ,	 'Bài 1. Sự chuyển thể'                                                      , 	'2023-03-05', '2023-03-05'),
					(1   , 	'Vật lí nhiệt'   ,	 'Bài 2. Thang nhiệt độ'                                                     , 	'2023-03-05', '2023-03-05'),
					(1   , 	'Vật lí nhiệt'   ,	 'Bài 3. Nội năng. Định luật 1 nhiệt động lực học'                           , 	'2023-03-05', '2023-03-05'),
					(1   , 	'Vật lí nhiệt'   ,	 'Bài 4. Thực hành đo nhiệt dung riêng, nhiệt nóng chảy, nhiệt hóa hơi riêng', 	'2023-03-05', '2023-03-05'),
					(1   , 	'Khí lí tưởng'   ,	 'Bài 5. Thuyết động học phân tử chất khí'                                   , 	'2023-03-05', '2023-03-05'),
					(1   , 	'Khí lí tưởng'   ,	 'Bài 6. Định luật Boyle. Định luật Charles'                                 , 	'2023-03-05', '2023-03-05'),
					(1   , 	'Khí lí tưởng'   ,	 'Bài 7. Phương trình trạng thái của khí lí tưởng'                           , 	'2023-03-05', '2023-03-05'),
					(1   , 	'Khí lí tưởng'   ,	 'Bài 8. Áp suất – động năng của phân tử khí'                                , 	'2023-03-05', '2023-03-05'),
					(1   , 	'Từ trường'      ,	 'Bài 9. Khái niệm từ trường'                                                , 	'2023-03-05', '2023-03-05'),
					(1   , 	'Từ trường'      ,	 'Bài 10. Lực từ. Cảm ứng từ'                                                , 	'2023-03-05', '2023-03-05'),
					(1   , 	'Từ trường'      ,	 'Bài 11. Thực hành đo độ lớn cảm ứng từ'                                    , 	'2023-03-05', '2023-03-05'),
					(1   , 	'Từ trường'      ,	 'Bài 12. Hiện tượng cảm ứng điện từ'                                        , 	'2023-03-05', '2023-03-05'),
					(1   , 	'Từ trường'      ,	 'Bài 13. Đại cương về dòng điện xoay chiều'                                 , 	'2023-03-05', '2023-03-05'),
					(1   , 	'Vật lí hạt nhân',	 'Bài 14. Hạt nhân và mô hình nguyên tử'                                     , 	'2023-03-05', '2023-03-05'),
					(1   , 	'Vật lí hạt nhân',	 'Bài 15. Năng lượng liên kết hạt nhân'                                      , 	'2023-03-05', '2023-03-05'),
					(1   , 	'Vật lí hạt nhân',	 'Bài 16. Phản ứng phân hạch, phản ứng nhiệt hạch và ứng dụng'               , 	'2023-03-05', '2023-03-05'),
					(1   , 	'Vật lí hạt nhân',	 'Bài 17. Hiện tượng phóng xạ'                                               , 	'2023-03-05', '2023-03-05'),
					(1   , 	'Vật lí hạt nhân',	 'Bài 18. An toàn phóng xạ'                                                  , 	'2023-03-05', '2023-03-05');

INSERT INTO Theory(	  lesson_id, 	theory_name,    video_url, 	  text_content, 	created_at,  updated_at ) 
VALUES
					( 1,  'Mô hình động học phân tử và cấu trúc vật chất'                               ,	'https://www.youtube.com/watch?v=lLFEqKl3sm4&t=19s'   , 'abc'	, '2023-03-05', '2023-03-05'),
					( 1,  'Sự chuyển thể của các chất'                                                  ,	'https://www.youtube.com/watch?v=lLFEqKl3sm4&t=19s'   , 'abc'	, '2023-03-05', '2023-03-05'),
					( 1,  'Sự nóng chảy'                                                                ,	'https://www.youtube.com/watch?v=lLFEqKl3sm4&t=19s'  , 'abc'	, '2023-03-05', '2023-03-05'),
					( 1,  'Sự hóa hơi'                                                                  ,	'https://www.youtube.com/watch?v=lLFEqKl3sm4&t=19s'   , 'abc'	, '2023-03-05', '2023-03-05'),
					( 2,  'Chiều truyền năng lượng nhiệt giữa hai vật chênh lệch nhiệt độ tiếp xúc nhau',	'https://www.youtube.com/watch?v=dL8yI7aRM-0'   , 'abc'	, '2023-03-05', '2023-03-05'),
					( 2,  'Thang nhiệt độ'                                                              ,	'https://www.youtube.com/watch?v=dL8yI7aRM-0'   , 'abc'	, '2023-03-05', '2023-03-05'),
					( 3,  'Nội năng'                                                                    ,	'https://www.youtube.com/watch?v=dL8yI7aRM-0'   , 'abc'	, '2023-03-05', '2023-03-05'),
					( 3,  'Cách làm thay đổi nội năng'                                                  ,	'https://www.youtube.com/watch?v=dL8yI7aRM-0'   , 'abc'	, '2023-03-05', '2023-03-05'),
					( 3,  'Định luật 1 của Nhiệt động lực học'                                          ,	'https://www.youtube.com/watch?v=dL8yI7aRM-0'   , 'abc'	, '2023-03-05', '2023-03-05');
                       
					    
INSERT INTO Exercise(	lesson_id, 	 exercise_name , 	created_at,  updated_at ) 
VALUES
					( 1,  'Mô hình động học phân tử và cấu trúc vật chất'                               ,	 '2023-03-05', '2023-03-05'),
					( 1,  'Sự chuyển thể của các chất'                                                  ,	 '2023-03-05', '2023-03-05'),
					( 1,  'Sự nóng chảy'                                                                ,	 '2023-03-05', '2023-03-05'),
					( 1,  'Sự hóa hơi'                                                                  ,	 '2023-03-05', '2023-03-05'),
					( 2,  'Chiều truyền năng lượng nhiệt giữa hai vật chênh lệch nhiệt độ tiếp xúc nhau',	 '2023-03-05', '2023-03-05'),
					( 2,  'Thang nhiệt độ'                                                              ,	 '2023-03-05', '2023-03-05'),
					( 3,  'Nội năng'                                                                    ,	 '2023-03-05', '2023-03-05'),
					( 3,  'Cách làm thay đổi nội năng'                                                  ,	 '2023-03-05', '2023-03-05'),
					( 3,  'Định luật 1 của Nhiệt động lực học'                                          ,	 '2023-03-05', '2023-03-05');					

INSERT INTO Question(	exercise_id , 	 question_name  ,    option_a   ,     option_b    ,   option_c       ,    option_d  ,	  correct_answer, 	created_at,  updated_at ) 
VALUES
					( 1             ,  'Câu 1: Ở thể rắn, các phân tử có đặc điểm gì về hình dạng và thể tích?'                          ,   'A. Có hình dạng xác định nhưng không có thể tích xác định.', 'B. Có thể tích xác định nhưng không có hình dạng xác định.'  , 'C. Có thể tích và hình dạng riêng xác định.'  , 'D. Không có hình dạng và thể tích riêng.'  , 'C. Có thể tích và hình dạng riêng xác định.', '2023-03-05', '2023-03-05'),
					( 1             ,  'Câu 2: Để giải thích các hiện tượng nhiệt quan sát được các nhà khoa học đã đưa ra mô hình nào?' ,   'A. Mô hình động học phân tử.'                              , 'B. Mô hình vật chất.'                                        , 'C. Mô hình nguyên tử Rutherford.'             , 'D. Mô hình toán học.'                      , 'A. Mô hình động học phân tử.'	              , '2023-03-05', '2023-03-05'),
					( 1             ,  'Câu 3: Ở thể khí, các phân tử chuyển động như thế nào?'                                          ,   'A. Chỉ dao động quanh vị trí cân bằng cố định.'            , 'B. Dao động quanh vị trí cân bằng luôn luôn thay đổi.'       , 'C. Chuyển động hỗn loạn.'                     , 'D. Chuyển động rất chậm.'                  , 'C. Chuyển động hỗn loạn.'	                  , '2023-03-05', '2023-03-05'),
					( 1             ,  'Câu 4: Lực tương tác giữa các phân tử là'                                                        ,	'A. lực đẩy.'                                               , 'B. lực hút.'                                                 , 'C. lực hút và lực đẩy.'                       , 'D. lực kéo.'                               , 'C. lực hút và lực đẩy.'	                  , '2023-03-05', '2023-03-05'),
					( 1             ,  'Câu 5: Sự hóa hơi có thể xảy ra qua hình thức nào?'                                              ,	'A. Bay hơi và sôi.'                                        , 'B. Bay hơi và nóng chảy.'                                    , 'C. Nóng chảy và thăng hoa.'                   , 'D. Sôi và đông đặc.'                       , 'A. Bay hơi và sôi.'	                      , '2023-03-05', '2023-03-05'),
					( 1             ,  'Câu 6: Sự hóa hơi xảy ra ở đâu?'                                                                 ,	'A. Bên trong chất lỏng. '                                  , 'B. Bề mặt của chất lỏng.'                                    , 'C. Bên trong và trên bề mặt chất lỏng.'       , 'D. Gần bề mặt chất lỏng.'                  , 'B. Bề mặt của chất lỏng.'	                  , '2023-03-05', '2023-03-05');
