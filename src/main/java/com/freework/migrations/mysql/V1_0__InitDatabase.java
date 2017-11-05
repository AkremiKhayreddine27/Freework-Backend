package com.freework.migrations.mysql;

import org.flywaydb.core.api.migration.spring.SpringJdbcMigration;
import org.springframework.jdbc.core.JdbcTemplate;


public class V1_0__InitDatabase implements SpringJdbcMigration {

    @Override
    public void migrate(JdbcTemplate jdbcTemplate) throws Exception {
        System.out.println("\n\n Create freelancers table");
        jdbcTemplate.execute(createFreelancersTable());
        System.out.println("\n\n Create users table");
        jdbcTemplate.execute(createUsersTable());
        System.out.println("\n\n Create companies table");
        jdbcTemplate.execute(createCompaniesTable());
        System.out.println("\n\n Create jobs table");
        jdbcTemplate.execute(createJobsTable());
        System.out.println("\n\n Create contests table");
        jdbcTemplate.execute(createContestsTable());
        System.out.println("\n\n Create entries table");
        jdbcTemplate.execute(createEntriesTable());
        System.out.println("\n\n Seeding freelancers table");
        jdbcTemplate.execute(seedFreelancersTable());
        System.out.println("\n\n Seeding users table");
        jdbcTemplate.execute(seedUsersTable());
        System.out.println("\n\n Seeding companies table");
        jdbcTemplate.execute(seedCompaniesTable());
        System.out.println("\n\n Seeding jobs table");
        jdbcTemplate.execute(seedJobsTable());
        System.out.println("\n\n Seeding contests table");
        jdbcTemplate.execute(seedContestsTable());
        System.out.println("\n\n Seeding entries table \n\n");
        jdbcTemplate.execute(seedEntriesTable());
    }

    private String createFreelancersTable(){
        return "CREATE TABLE freelancers (\n" +
                "  id int(10) UNSIGNED NOT NULL,\n" +
                "  name varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,\n" +
                "  email varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,\n" +
                "  password varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL,\n" +
                "  phone varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL,\n" +
                "  address_id int(10) UNSIGNED DEFAULT NULL,\n" +
                "  freelancer_id BIGINT UNSIGNED NOT NULL,\n"+
                "  freelancer_type VARCHAR(50) NOT NULL,\n"+
                "  facebook varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL,\n" +
                "  linkedin varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL,\n" +
                "  about text COLLATE utf8mb4_unicode_ci,\n" +
                "  avatar varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL,\n" +
                "  created_at TIMESTAMP DEFAULT NULL,\n"+
                "  updated_at TIMESTAMP DEFAULT NULL,\n"+
                "  PRIMARY KEY (id)\n"+
                ");";
    }

    private String createUsersTable(){
        return "CREATE TABLE users (\n" +
                "  id int(10) UNSIGNED NOT NULL,\n" +
                "  birthday DATE DEFAULT NULL,\n"+
                "  PRIMARY KEY (id)\n"+
                ");";
    }

    private String createCompaniesTable(){
        return "CREATE TABLE companies (\n" +
                "  id int(10) UNSIGNED NOT NULL,\n" +
                "  established_on DATE DEFAULT NULL,\n"+
                "  PRIMARY KEY (id)\n"+
                ");";
    }

    private String createJobsTable(){
        return "CREATE TABLE `jobs` (\n" +
                "  `id` int(10) UNSIGNED NOT NULL,\n" +
                "  `title` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,\n" +
                "  `description` text COLLATE utf8mb4_unicode_ci NOT NULL,\n" +
                "  created_at TIMESTAMP DEFAULT NULL,\n"+
                "  updated_at TIMESTAMP DEFAULT NULL,\n"+
                "  PRIMARY KEY (id)\n"+
                ");";
    }

    private String createContestsTable(){
        return "create table contests (\n"
                +"   id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,\n"
                +"   title VARCHAR(50) NOT NULL,\n"
                +"   description TEXT NOT NULL,\n"
                +"   prize INT NOT NULL,\n"
                +"   duration INT NOT NULL,\n"
                +"   type VARCHAR(50) NOT NULL, \n"
                +"   status VARCHAR(50) NOT NULL,\n"
                +"   publisher_id BIGINT UNSIGNED DEFAULT NULL,\n"
                +"   winner_id BIGINT UNSIGNED DEFAULT NULL,\n"
                +"   job_id BIGINT UNSIGNED DEFAULT NULL,\n"
                +"   created_at TIMESTAMP DEFAULT NULL,\n"
                +"   updated_at TIMESTAMP DEFAULT NULL,\n"
                + "  PRIMARY KEY (id)\n"
                +");";
    }

    private String createEntriesTable(){
        return "create table entries (\n"
                +"   id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,\n"
                +"   title VARCHAR(50) NOT NULL,\n"
                +"   description TEXT NOT NULL,\n"
                +"   prize INT NOT NULL,\n"
                +"   contest_id BIGINT UNSIGNED DEFAULT NULL,\n"
                +"   freelancer_id BIGINT UNSIGNED DEFAULT NULL,\n"
                +"   created_at TIMESTAMP DEFAULT NULL,\n"
                +"   updated_at TIMESTAMP DEFAULT NULL,\n"
                + "  PRIMARY KEY (id)\n"
                +");";
    }

    private String seedFreelancersTable(){
        return "INSERT INTO freelancers (id, freelancer_id, freelancer_type, name, email, password, phone, address_id, facebook, linkedin, about, avatar, created_at, updated_at) VALUES\n" +
                "(1, 1 ,'USER' ,'Mr. Dashawn Klocko MD', 'jermey40@example.com', '$2y$10$p/rXgqSP2a99.dVqTK7VKOyYsrMwUSwMfSqrX6lL1pKyl5yDHhv6q', '+1 (484) 954-0106', 21, 'http://www.heller.com/sequi-amet-eveniet-quo-accusamus-qui', 'http://www.watsica.info/est-asperiores-eum-quae-quibusdam', 'Sed enim ad molestias alias esse odio. Sit atque illo tempore voluptatibus. Neque voluptatibus earum assumenda quia consequatur. Doloremque earum quis quos saepe voluptate et eum eligendi.', NULL, '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(2, 2 ,'USER' ,'Mr. John Doe', 'jermey47@example.com', '$2y$10$p/rXgqSP2a99.dVqTK7VKOyYsrMwUSwMfSqrX6lL1pKyl5yDHhv6q', '+1 (484) 954-0106', 21, 'http://www.heller.com/sequi-amet-eveniet-quo-accusamus-qui', 'http://www.watsica.info/est-asperiores-eum-quae-quibusdam', 'Sed enim ad molestias alias esse odio. Sit atque illo tempore voluptatibus. Neque voluptatibus earum assumenda quia consequatur. Doloremque earum quis quos saepe voluptate et eum eligendi.', NULL, '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(3, 1 ,'COMPANY' ,'Dite-le MD', 'jermey45@example.com', '$2y$10$p/rXgqSP2a99.dVqTK7VKOyYsrMwUSwMfSqrX6lL1pKyl5yDHhv6q', '+1 (484) 954-0106', 21, 'http://www.heller.com/sequi-amet-eveniet-quo-accusamus-qui', 'http://www.watsica.info/est-asperiores-eum-quae-quibusdam', 'Sed enim ad molestias alias esse odio. Sit atque illo tempore voluptatibus. Neque voluptatibus earum assumenda quia consequatur. Doloremque earum quis quos saepe voluptate et eum eligendi.', NULL, '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(4, 2 ,'COMPANY' ,'Barton Borer', 'jstiedemann@example.net', '$2y$10$p/rXgqSP2a99.dVqTK7VKOyYsrMwUSwMfSqrX6lL1pKyl5yDHhv6q', '740-702-8214 x216', 45, 'http://gibson.com/', 'http://www.damore.com/dolores-maxime-sint-debitis-iste', 'Voluptatem voluptatum at porro aut aut. Et repellat ut ut culpa atque ut ex. Saepe quo doloribus adipisci ut error pariatur architecto autem. Et molestias dolorem nihil dolor voluptatem sint.', NULL, '2017-09-11 19:46:00', '2017-09-11 19:46:00');";
    }

    private String seedUsersTable(){
        return "INSERT INTO users (id) VALUES\n" +
                "(1),\n" +
                "(2);";
    }

    private String seedCompaniesTable(){
        return "INSERT INTO companies (id) VALUES\n" +
                "(1),\n" +
                "(2);";
    }


    private String seedJobsTable(){
        return "INSERT INTO `jobs` (`id`, `title`, `description`, `created_at`, `updated_at`) VALUES\n" +
                "(1, 'Sawing Machine Setter', 'Ex iure dicta ex suscipit blanditiis. Nihil adipisci voluptatem quibusdam pariatur qui omnis consequatur. Qui ut voluptatibus voluptas.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(2, 'Carver', 'Provident dolorem fugiat numquam architecto commodi ex sit. Aut consequuntur quaerat quam maxime. Debitis perferendis nihil amet possimus modi delectus impedit voluptatum.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(3, 'Tank Car', 'Velit cumque reiciendis quia culpa. Consequatur aut autem libero pariatur. Saepe tempore doloremque libero omnis debitis. Repudiandae rerum ut sed est. Voluptas odit sed ea est odio laborum.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(4, 'Welder-Fitter', 'Maiores tempora quis suscipit. Quibusdam quis porro omnis doloribus. Id aliquam fuga quam omnis pariatur similique dolore. Non nam eligendi ea. Quod aut exercitationem praesentium ea.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(5, 'Gas Pumping Station Operator', 'Dolore officia rerum vitae veritatis molestiae distinctio ipsum. Unde atque non eos velit illo aut est consequatur. Aperiam recusandae qui quia iusto quo et. Occaecati rem ipsa autem tenetur.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(6, 'Obstetrician', 'Distinctio dolor quia accusamus error corporis. Est nostrum ipsa architecto molestiae quia. Consequatur ipsum nobis sit aliquid.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(7, 'Skin Care Specialist', 'Commodi blanditiis voluptatem ipsum aperiam ullam eos eaque. Esse itaque quaerat qui dolorum. Neque hic temporibus et et. Et atque voluptatum soluta officia et alias expedita.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(8, 'Pipelayer', 'Et unde aliquid occaecati. Fuga sit ipsa voluptatem id itaque. Illum pariatur in natus dolores.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(9, 'Education Teacher', 'Rem eveniet quas harum dignissimos minus in accusamus. Rerum maxime repudiandae tempora voluptatem commodi. Cumque dignissimos ut quis cumque qui dolorem omnis. Sit aut sed doloremque quo vitae commodi.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(10, 'Chemical Plant Operator', 'Doloribus repellendus et quia eius quia quidem. Dolores perferendis consequatur ad necessitatibus. Blanditiis vel omnis sit provident. Dolores sequi nam ut eos fugiat.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(11, 'Private Sector Executive', 'Enim voluptatem ullam sed ut quisquam. Animi perferendis porro quia cumque libero omnis quia. Quos et aut voluptatem eius eum dolorum suscipit.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(12, 'HR Specialist', 'Qui ducimus et autem officia omnis non. Odio dolor sed et totam repudiandae aliquid et. Quos illo id itaque quia quia.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(13, 'Title Examiner', 'Velit nisi quis cupiditate eos rerum et molestiae. Illum veniam exercitationem itaque nobis qui. Quos cumque impedit qui voluptates.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(14, 'Communications Equipment Operator', 'Doloribus quidem doloribus voluptatem dolor iusto ex perspiciatis iure. Ad dolores iste dolores vitae distinctio nesciunt expedita. Maxime at eos et velit. Dolor commodi magni nulla quis quod ut.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(15, 'Police Identification OR Records Officer', 'Vel velit quas sit. Cum voluptas fugit nihil repellat magni asperiores voluptatem. Quas dignissimos ad repellat ea.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(16, 'Mathematical Technician', 'Voluptatem dolorum eos nam est ut. Sint suscipit sit molestiae illum. Dolore asperiores non est id quaerat voluptatibus. Sed atque officiis tempora nostrum aut velit laborum. Dicta qui porro non id quas autem aut et.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(17, 'Director Of Talent Acquisition', 'Recusandae doloribus vel eos consequatur officiis rem eos laboriosam. Quia et tempora id quam. Voluptatum exercitationem qui ducimus iure iusto.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(18, 'Vocational Education Teacher', 'Cum voluptates assumenda vel aut. Facere ut eum inventore et maxime aliquam. Quod aut ipsum voluptates aliquam.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(19, 'Credit Checker', 'Quidem rerum earum molestiae sapiente. Quibusdam delectus nisi harum odit eaque quia. Id labore reprehenderit quaerat id.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(20, 'Librarian', 'Nobis minima cum ut cupiditate molestias. Omnis inventore enim ducimus aut quia ut sit. Non nam dolorem saepe sed ut expedita amet. Non accusantium nihil tenetur culpa.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(21, 'Engraver', 'Eius reprehenderit voluptate voluptas voluptate doloremque velit necessitatibus ipsam. Sapiente porro ea id et corrupti. Assumenda ut delectus dignissimos aut est. Hic cum sit blanditiis doloremque consequatur laborum.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(22, 'Electronic Engineering Technician', 'Voluptates quam architecto perspiciatis tempore id. Aut eligendi et consequuntur tenetur in. Sint ut exercitationem perspiciatis sit non.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(23, 'Maintenance and Repair Worker', 'Dignissimos repellendus odit reprehenderit libero omnis. Quae et maiores explicabo aperiam. Reprehenderit quasi totam magnam aut quis at sunt similique. Eligendi dolorum earum aut laudantium et necessitatibus rerum.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(24, 'Psychology Teacher', 'Maiores vitae nam error tempore est saepe accusantium. Nam labore tempora neque. Ipsa blanditiis quibusdam excepturi quas aliquam adipisci necessitatibus.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(25, 'Occupational Health Safety Specialist', 'Autem aut fugit cumque architecto eos. Dolorem ut autem voluptas possimus dolor et reprehenderit. Quae inventore quis necessitatibus occaecati ut id et. Voluptate pariatur quasi sed rerum consequatur maxime. Praesentium exercitationem enim porro distinctio aut nemo.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(26, 'Armored Assault Vehicle Officer', 'Natus eaque iure eius neque accusamus perspiciatis. Molestiae optio aut quis omnis optio cupiditate excepturi. Magnam ut suscipit consequuntur eaque.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(27, 'Plating Operator', 'Eum fuga ut aut enim est minima. Et est excepturi harum sunt vel quibusdam eum. Voluptatem ut est ea aut perferendis ut provident labore.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(28, 'Physical Therapist Assistant', 'Doloremque ipsa aliquam cum voluptatem. Vel omnis ipsam ipsa qui voluptas. Expedita accusantium ut facilis asperiores dolore aperiam corrupti. Libero ut voluptatum enim enim quia tempora et suscipit.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(29, 'Paperhanger', 'Voluptas itaque eos animi qui possimus. Velit voluptatem distinctio et. Distinctio hic accusantium quaerat velit. Dolore est consequatur qui soluta rerum iusto esse.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(30, 'Manufactured Building Installer', 'Beatae est et quaerat dolore. Aperiam dicta consectetur quod inventore et occaecati. Est ratione pariatur recusandae doloribus ut nesciunt. Explicabo suscipit accusantium est sed et aut optio aperiam. Adipisci autem facilis pariatur aut dolor.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(31, 'Refractory Materials Repairer', 'Quae deleniti vel eos est. Facere ut qui sed ut recusandae voluptatem voluptatem. Autem vel voluptas facilis autem. Aliquid laborum sint asperiores ex ad cum.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(32, 'Electrical Power-Line Installer', 'Vel autem ipsam fugiat a. Illum voluptas sit tempore incidunt. Ut illo eum nihil labore est.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(33, 'Travel Guide', 'Fuga molestiae dolorem aliquam dolorem eos et aperiam. Magnam dolor omnis recusandae officiis neque eum magnam. Rem et quisquam provident quia tenetur eos beatae.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(34, 'Construction', 'Ducimus repudiandae ea voluptas atque ducimus odio. Saepe ad fuga ab. Dignissimos laborum numquam ullam a quos ut sunt.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(35, 'Veterinarian', 'Aliquid enim earum repellat nihil qui atque et. Reprehenderit sed a facilis eveniet porro ratione. Sed consectetur in iste earum nihil quam ut. Sunt iusto nulla reiciendis. Alias quia vel unde nisi vero labore earum.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(36, 'Scientific Photographer', 'Eum repellendus laborum nihil sed accusamus ipsa. Qui unde asperiores consequatur harum. Quos sit veniam quas et.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(37, 'Security Guard', 'Totam earum vel at non aut voluptatibus. Error dolorem aut quia et.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(38, 'Architectural Drafter OR Civil Drafter', 'Consequatur voluptas nihil facilis nisi molestias unde quis alias. Consequatur saepe neque vitae ut. Repudiandae quia repudiandae porro explicabo perspiciatis sed facilis.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(39, 'Substance Abuse Counselor', 'Dolorem ut ut rem ratione non molestiae. Quia quia recusandae veritatis adipisci.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(40, 'Graphic Designer', 'Qui enim quae quia voluptas at deserunt. Repudiandae eius eligendi sint qui sint. Deleniti non in nihil. Ut nemo ratione necessitatibus eligendi enim quidem. Et tempora aut cupiditate nulla praesentium beatae.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(41, 'Crane and Tower Operator', 'Repellat architecto ullam dolores itaque modi. Sint ipsa doloremque reprehenderit vel perspiciatis doloribus. In quis accusantium nostrum ut.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(42, 'Extruding Machine Operator', 'Temporibus dignissimos molestiae atque cumque excepturi vel nemo. Quisquam corrupti est numquam saepe et.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(43, 'Medical Secretary', 'Fugiat eum sit fugiat ea ea nulla. Veritatis quod dolorem laborum soluta. Mollitia rerum suscipit quidem quisquam quo tenetur dolor reprehenderit. Amet voluptas minus dolorum consequatur aliquam. Quis maxime sint excepturi rerum nihil.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(44, 'Carpenter', 'Veniam earum non est non est qui. Ea numquam ut quia voluptate omnis rerum. Corrupti molestias deserunt minima. Veritatis sed tenetur omnis ut occaecati enim.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(45, 'Sewing Machine Operator', 'Voluptatibus consequatur harum fuga. Iste vitae est sit voluptates distinctio. Nesciunt odio eveniet explicabo sapiente fugiat. Quam veniam rem aut nihil quisquam adipisci qui laborum.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(46, 'Rail Yard Engineer', 'Doloribus recusandae est est fuga recusandae molestiae ut. Est voluptas enim rerum et. Magnam impedit eum deserunt dolorum. Eaque voluptas sit dolor harum. Consequatur est rerum et est.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(47, 'Film Laboratory Technician', 'Magnam deserunt rerum saepe voluptas numquam. Minus perspiciatis quam dolorum id dolor possimus ea. Labore porro rem cumque molestiae saepe placeat ut et. Ipsum optio voluptatibus veniam vel.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(48, 'Millwright', 'Repellendus excepturi sequi omnis temporibus. Eligendi non ipsa tenetur tenetur neque velit ea. Deleniti maiores sit dolores officiis est ut.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(49, 'Claims Adjuster', 'Totam ut accusamus ratione qui rerum. Voluptates omnis a tenetur sint quis.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(50, 'Child Care Worker', 'Placeat veritatis dolorem at dolorem enim sapiente. Numquam sunt enim molestiae ut quasi molestias eos. Saepe rerum non eum doloremque nihil molestias ut delectus.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(51, 'Computer-Controlled Machine Tool Operator', 'Quia laboriosam enim aliquam molestiae ut fugit quia. Deserunt saepe officiis quam. Quasi consequatur iusto earum rerum.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(52, 'Model Maker', 'In aut voluptas autem doloribus aspernatur dolor. Qui autem aliquid qui laboriosam eaque nihil et. Voluptas reiciendis explicabo voluptatem sed totam dicta.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(53, 'Chemistry Teacher', 'Amet dolorem doloremque alias nihil. Cumque nesciunt vero quia odit pariatur. Doloremque quo dolor deserunt perspiciatis quos rerum voluptatibus.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(54, 'Data Entry Operator', 'Officiis quasi sed nobis similique dolorum veniam aut. Alias magnam et sed placeat adipisci voluptatibus saepe. Aliquid molestiae reiciendis corporis cum.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(55, 'Mechanical Inspector', 'Sit dolor et et. Doloremque illum et et aut quaerat soluta sapiente quo. Accusamus et tempora omnis ab placeat. Commodi adipisci quo rerum explicabo consectetur hic.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(56, 'Fraud Investigator', 'Ut eum natus culpa fuga. Distinctio aut consequatur reiciendis sit porro soluta ullam quia. Aut magni aspernatur et architecto.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(57, 'Environmental Engineering Technician', 'Asperiores dicta veniam eum voluptates et. Recusandae vero minima non pariatur et natus vitae nulla. Nesciunt nesciunt dolor magnam qui ex eos sapiente occaecati. Praesentium placeat et odio quia ut et.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(58, 'Grounds Maintenance Worker', 'Et voluptas dolores cum labore nihil eaque iusto. Beatae quidem eos vero animi quod esse. Hic porro et dolore.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(59, 'Precious Stone Worker', 'Odio aut eos ipsam voluptas. Occaecati itaque repellendus repellendus distinctio. Aliquid omnis officia aliquid tempore itaque.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(60, 'Gaming Supervisor', 'Voluptatem eum quaerat quo sapiente dolore adipisci molestiae. Adipisci reiciendis ea quia aut. Esse voluptates aut nesciunt.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(61, 'Composer', 'Sed assumenda incidunt adipisci esse aperiam quas quia amet. Tempora molestiae nisi corporis eos totam modi.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(62, 'Talent Director', 'Est rerum molestiae dolor alias. In quidem et dolorem fugit et iusto cupiditate quia. Voluptatem iure laudantium soluta minima quo officiis amet aut.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(63, 'Photographic Developer', 'Explicabo eius dignissimos odio ullam voluptas. Voluptatem excepturi ea aperiam sit. Ut non voluptatem aspernatur distinctio ad. Fuga commodi debitis dicta laborum recusandae. Quam rem ea non deserunt iure modi.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(64, 'Entertainment Attendant', 'Omnis cupiditate distinctio et similique. Voluptatem voluptatem hic vero ab. Omnis atque similique autem perferendis minus aut voluptas. A et sequi ullam cupiditate aut et enim.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(65, 'Cashier', 'Iure illum dolorem laborum quas aut impedit repellendus. Ipsam blanditiis illum et reiciendis ut excepturi distinctio. Ut eius qui commodi aut similique maxime. Debitis quidem beatae enim molestiae aut et aperiam. Quo nobis error dolores corporis et et ea voluptas.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(66, 'Payroll Clerk', 'Autem qui rem sunt labore. Consequatur libero id maiores fugiat sint. Expedita minus et non quia culpa commodi id. Et culpa sunt sed perspiciatis.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(67, 'Patternmaker', 'Voluptas temporibus itaque et voluptatum doloremque. Odio molestias qui sit. Nam vel accusantium molestiae vel blanditiis magnam. Vel natus est iure et.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(68, 'Educational Psychologist', 'Sint veritatis sunt expedita porro quia rerum molestiae. Modi voluptas natus natus dolor incidunt vero. Aut vitae cum earum voluptatum sit quae velit. Ea ipsa doloribus modi mollitia.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(69, 'Food Preparation Worker', 'Et dolor quasi soluta consequatur veritatis deleniti odit. Voluptatem nulla velit quae. In repellendus est numquam mollitia ad quo.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(70, 'Woodworking Machine Operator', 'Quo consequatur odit porro provident. Dignissimos quia non adipisci ut. Quibusdam saepe quisquam aut nihil quo blanditiis possimus.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(71, 'Clinical Psychologist', 'Perspiciatis omnis deserunt doloribus aut libero hic eum amet. Quis asperiores sit sit et magni. Illo laboriosam ex iure excepturi harum.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(72, 'Nuclear Technician', 'Aut qui deserunt et illo sapiente. Eos occaecati ex deserunt omnis et. Alias est consequatur et quos eum voluptates. Dolore et nemo corrupti officia est amet.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(73, 'Insurance Investigator', 'Excepturi sit magnam tempore inventore voluptas quia qui et. Quo provident doloribus nobis quis. Provident recusandae ut eum dolores est aut qui. Omnis ducimus eaque qui facere eveniet aut. Molestiae velit commodi architecto molestiae qui et quam.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(74, 'Artillery Crew Member', 'Distinctio impedit debitis nihil porro eaque placeat. Corrupti cumque ut aut perspiciatis odit assumenda. Consequuntur sequi non dolorem fugit nemo quas.', '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(75, 'Diamond Worker', 'Eum dolores quo occaecati distinctio deleniti. Eos voluptate doloribus nihil occaecati repellat rerum. Corrupti cumque odit eveniet sit sint vero quo in.', '2017-09-11 19:46:00', '2017-09-11 19:46:00');";
    }
    
    private String seedContestsTable(){
        return "INSERT INTO contests (id, title, description, prize, duration, type, status, publisher_id, winner_id, job_id, created_at, updated_at) VALUES\n" +
                "(1, 'Deleniti quo quisquam numquam non.', 'Sed molestias quaerat optio maiores nihil ut officia. Repellat qui sapiente mollitia ad ut. Adipisci error magni consequatur ipsum aut facere molestiae. Vero non ex mollitia eum.', 3250, 11, 'image', 'active', 1, 1, 1, '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(2, 'Sint exercitationem voluptatum cupiditate magni.', 'Aliquam eius ut quo tempore cum et quae. Iure explicabo beatae voluptatem a aliquid itaque quaerat. Unde eum aut quas dignissimos.', 1475, 29, 'image', 'active', 1, 2, 1, '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(3, 'Sapiente soluta sunt itaque similique quo.', 'Iure eveniet est exercitationem et. Accusantium impedit eos commodi ut a deleniti velit quam.', 4387, 17, 'image', 'active', 1, 1, 1, '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(4, 'Optio rerum numquam mollitia dolorem hic quae.', 'Nihil deserunt cupiditate optio sint. Magnam optio nemo natus quis laborum et repellat. In voluptatem et reprehenderit cupiditate voluptas provident omnis repellendus. Reprehenderit similique blanditiis sunt illum exercitationem.', 2735, 14, 'image', 'active', 1, 1, 1, '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(5, 'Id veritatis optio dignissimos ducimus totam fuga.', 'Iure iure aut id ut consequatur. Aliquid eum est aut laboriosam ea est voluptatem alias. Vel sunt debitis rem enim veniam non. Enim voluptatem non quidem repudiandae sunt dolore.', 3331, 42, 'image', 'active', 2, 1, 1, '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(6, 'Molestiae praesentium est autem quia non minima.', 'Quia laudantium saepe nam omnis voluptatibus sit enim. Dolor ducimus maxime quo rerum hic. Odio sunt maxime perspiciatis fugit alias odit et consequatur.', 1225, 33, 'image', 'active', 2, 1, 1, '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(14, 'Qui qui sunt eius placeat laboriosam.', 'Autem perspiciatis voluptates dolorem. Facere excepturi aut tenetur ea rem tenetur. Est nihil consequatur ea autem minus.', 1400, 16, 'image', 'active', 1, 2, 1, '2017-09-11 19:46:00', '2017-09-11 19:46:00');";
    }

    private String seedEntriesTable(){
        return "INSERT INTO entries (id, title, description, prize, contest_id, freelancer_id, created_at, updated_at) VALUES\n" +
                "(1, 'Sit qui sunt laudantium et est.', 'Rem inventore delectus ducimus. Exercitationem quos et sed dolores ullam possimus. Vitae magnam adipisci numquam atque quasi rem corrupti.', 352, 1, 1,'2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(2, 'Vel eveniet et facilis aut quam quod.', 'Dolorum rerum sapiente itaque ratione cumque et dolore. Perferendis dolor eos non qui sapiente. Quae recusandae nobis repellendus est odit repellendus.', 362, 3, 1, '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(3, 'Non sed occaecati ea magnam nihil aut.', 'Fuga quis voluptas in laboriosam. Ex quod excepturi rerum ipsum. Nobis natus perspiciatis ut voluptatum aut. Qui qui et velit.', 216, 5, 1,'2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(4, 'Dolorum aut quia dolor voluptate numquam accusamus repudiandae aut.', 'Doloribus explicabo ut qui est cumque. Recusandae ab vel autem est omnis harum. Magni ratione id est laboriosam.', 353, 6, 1,'2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(5, 'Optio dolorum doloremque deleniti cum itaque.', 'Qui veritatis nostrum quae accusantium aperiam nihil autem. Veritatis nihil aut ut perspiciatis voluptatem voluptatem. Et adipisci iste blanditiis possimus sed adipisci magnam.', 279, 2, 2, '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(6, 'Rerum quia itaque aspernatur nesciunt.', 'Fugit enim consectetur animi est aut sunt voluptatibus eligendi. Aliquam dolores commodi consequatur. Explicabo quod sit qui facere sint.', 188, 4, 2, '2017-09-11 19:46:00', '2017-09-11 19:46:00'),\n" +
                "(7, 'Accusantium quibusdam vero esse libero omnis qui officiis qui.', 'Voluptatem dolore aperiam et rem earum sed. Repellendus illo ipsa quo ut omnis voluptas. Non iure quis nam deserunt.', 388, 14, 2, '2017-09-11 19:46:00', '2017-09-11 19:46:00');";
    }
    
    

}
