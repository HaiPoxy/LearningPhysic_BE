package com.vti.be.util;

import com.vti.be.entity.*;
import com.vti.be.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class ImportDataRunner implements CommandLineRunner {

    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    private IChangePasswordRequestRepository changePasswordRequestRepository;

    @Autowired
    private IUserExamAttemptRepository userExamAttemptRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private IArticleRepository articleRepository;

    @Autowired
    private IAuthRepository authRepository;

    @Autowired
    private IOrderRepository orderRepository;

    @Autowired
    private IOrderItemRepository orderItemRepository;

    @Autowired
    private IExerciseRepository exerciseRepository;

    @Autowired
    private IExamRepository examRepository;

    @Autowired
    private ILessonRepository lessonRepository;

    @Autowired
    private IFavoritePostRepository favoritePostRepository;

    @Autowired
    private ICourseRepository courseRepository;

    @Autowired
    private ITheoryRepository theoryRepository;

    @Autowired
    private ICartItemRepository cartItemRepository;

    @Autowired
    private IEbookRepository ebookRepository;

    @Autowired
    private IQuestionRepository questionRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void run(String... args) throws Exception {
        // Import data into Account table
        Account admin = new Account();
        admin.setFullName("Admin User");
        admin.setEmail("admin@example.com");
        admin.setPassword("password");
        admin.setRole(Account.Role.ADMIN);
        admin.setStatus("ACTIVE");
        accountRepository.save(admin);

        Account user = new Account();
        user.setFullName("Regular User");
        user.setEmail("user@example.com");
        user.setPassword("password");
        user.setRole(Account.Role.USER);
        user.setStatus("ACTIVE");
        accountRepository.save(user);

        // Import data into ChangePasswordRequest table
        ChangePasswordRequest changeRequest = new ChangePasswordRequest();
        changeRequest.setEmail(user.getEmail());
        changeRequest.setExpirationDate(LocalDateTime.now().plusDays(1));
        changeRequest.setToken("sample-token");
        changeRequest.setUsed(false);
        changePasswordRequestRepository.save(changeRequest);

        // Import data into Exam table
        Exam exam = new Exam();
        exam.setExamName("Sample Exam");
        exam.setCreatedAt(LocalDateTime.now());
        exam.setUpdatedAt(LocalDateTime.now());
        examRepository.save(exam);

        // Import data into Lesson table
        Lesson lesson = new Lesson();
        lesson.setLessonName("Sample Lesson");
        lesson.setCourse(null); // Set course if needed
        lesson.setCreatedAt(LocalDateTime.now());
        lesson.setUpdatedAt(LocalDateTime.now());
        lessonRepository.save(lesson);

        // Import data into Theory table
        Theory theory = new Theory();
        theory.setVideoUrl("http://example.com/video");
        theory.setTextContent("Sample theory content.");
        theory.setLesson(lesson);
        theory.setCreatedAt(LocalDateTime.now());
        theory.setUpdatedAt(LocalDateTime.now());
        theoryRepository.save(theory);

        // Import data into UserExamAttempt table
        UserExamAttempt attempt = new UserExamAttempt();
        attempt.setAccount(user);
        attempt.setExam(exam);
        attempt.setScore(85);
        attempt.setAnswers("[{\"questionId\":1,\"answer\":\"A\"}]"); // Example JSON
        attempt.setFeedback("Good attempt");
        attempt.setAttemptDate(LocalDateTime.now());
        attempt.setUpdatedAt(LocalDateTime.now());
        userExamAttemptRepository.save(attempt);

        // Import data into Post table
        Post post = new Post();
        post.setTitle("Sample Post");
        post.setContent("This is a sample post content.");
        post.setAccount(admin);
        post.setGrade(5);
        post.setNumberLike(10);
        post.setStatus(Post.postStatus.valueOf("ACTIVE"));
        post.setCreatedAt(LocalDateTime.now());
        post.setUpdatedAt(LocalDateTime.now());
        postRepository.save(post);

        // Import data into Article table
        Article article = new Article();
        article.setTitle("Sample Article");
        article.setContent("This is a sample article content.");
        article.setImageUrl("http://example.com/image");
        article.setCreatedAt(LocalDateTime.now());
        article.setUpdatedAt(LocalDateTime.now());
        articleRepository.save(article);

        // Import data into Order and OrderItem tables
        Order order = new Order();
        order.setAccount(user);
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("PENDING");
        order.setCreatedAt(LocalDateTime.now());
        order.setUpdatedAt(LocalDateTime.now());
        orderRepository.save(order);

        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setProductId(1); // Example product ID
        orderItem.setProductName(1); // Example product name ID
        orderItem.setAuthor("Author Name");
        orderItem.setQuantity(1);
        orderItem.setType("Product Type");
        orderItem.setPrice(9.99);
        orderItemRepository.save(orderItem);

        // Import data into Exercise table
        Exercise exercise = new Exercise();
        exercise.setLesson(lesson);
        exercise.setQuestion("Sample question?");
        exercise.setAnswer("Sample answer.");
        exercise.setCreatedAt(LocalDateTime.now());
        exercise.setUpdatedAt(LocalDateTime.now());
        exerciseRepository.save(exercise);

        // Import data into Course table
        Course course = new Course();
        course.setCourseName("Sample Course");
        course.setDescription("This is a sample course description.");
        course.setPrice(BigDecimal.valueOf(49.99));
        course.setClassLevel("Beginner");
        course.setImageUrl("http://example.com/course-image");
        course.setCreatedAt(LocalDateTime.now());
        course.setUpdatedAt(LocalDateTime.now());
        courseRepository.save(course);

        // Import data into FavoritePost table
        FavoritePost favoritePost = new FavoritePost();
        favoritePost.setAccount(user);
        favoritePost.setPost(post);
        favoritePost.setStatus("LIKED");
        favoritePostRepository.save(favoritePost);

        // Import data into CartItem table
        CartItem cartItem = new CartItem();
        cartItem.setAccount(user);
        cartItem.setProductId(1); // Example product ID
        cartItem.setQuantity(1);
        cartItem.setPrice(15.99);
        cartItem.setStatus("IN_CART");
        cartItem.setType("Ebook");
        cartItem.setCreatedAt(LocalDateTime.now());
        cartItem.setUpdatedAt(LocalDateTime.now());
        cartItemRepository.save(cartItem);

        // Import data into Ebook table
        Ebook ebook = new Ebook();
        ebook.setTitle("Sample Ebook");
        ebook.setAuthor("Author Name");
        ebook.setCategory("Category Name");
        ebook.setDescription("This is a sample ebook description.");
        ebook.setPrice(BigDecimal.valueOf(9.99));
        ebook.setEbookUrl("http://example.com/ebook-url");
        ebook.setCreatedAt(LocalDateTime.now());
        ebook.setUpdatedAt(LocalDateTime.now());
        ebookRepository.save(ebook);

        // Import data into Question table
        Question question = new Question();
        question.setExam(exam);
        question.setQuestion("What is the capital of France?");
        question.setOptions("[\"Paris\",\"London\",\"Berlin\",\"Madrid\"]"); // Example options in JSON
        question.setCorrectAnswer("Paris");
        question.setCreatedAt(LocalDateTime.now());
        question.setUpdatedAt(LocalDateTime.now());
        questionRepository.save(question);

        // Import data into Comment table
        Comment comment = new Comment();
        comment.setPost(post);
        comment.setAccount(user);
        comment.setContent("This is a sample comment.");
        comment.setCreatedAt(LocalDateTime.now());
        comment.setUpdatedAt(LocalDateTime.now());
        commentRepository.save(comment);

        System.out.println("Data import completed successfully.");
    }
}
