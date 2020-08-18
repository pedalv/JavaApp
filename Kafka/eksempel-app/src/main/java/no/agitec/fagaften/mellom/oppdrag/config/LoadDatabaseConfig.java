package no.agitec.fagaften.mellom.oppdrag.config;

import lombok.extern.slf4j.Slf4j;
import no.agitec.fagaften.mellom.oppdrag.domain.*;
import no.agitec.fagaften.mellom.oppdrag.domain.comment.Post;
import no.agitec.fagaften.mellom.oppdrag.domain.comment.PostComment;
import no.agitec.fagaften.mellom.oppdrag.domain.comment.PostDetail;
import no.agitec.fagaften.mellom.oppdrag.domain.comment.PostTag;
import no.agitec.fagaften.mellom.oppdrag.repository.*;
import no.agitec.fagaften.mellom.oppdrag.repository.comment.PostCommentRepository;
import no.agitec.fagaften.mellom.oppdrag.repository.comment.PostDetailRepository;
import no.agitec.fagaften.mellom.oppdrag.repository.comment.PostRepository;
import no.agitec.fagaften.mellom.oppdrag.repository.comment.PostTagRepository;
import no.agitec.fagaften.mellom.oppdrag.repository.store.*;
import no.agitec.fagaften.mellom.oppdrag.store.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Configuration
@Slf4j
public class LoadDatabaseConfig {

    @Bean(name = "employee")
    CommandLineRunner initDatabase(EmployeeRepository employ) {
        return (args) -> {
            log.info("Preloading " + employ.saveAndFlush(new Employee("Carl", "Kristian Eriksen", "Seniorutvikler")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Francois", "Allix", "Seniorutvikler")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Frode", "Johansen", "Seniorutvikler")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Maria", "Selivanova", "Seniorutvikler")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Pedro", "Alves", "Seniorutvikler")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Runar", "Opsahl", "Seniorutvikler")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Steinar", "Haug", "Seniorutvikler")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Ståle", "Sannerud", "Seniorutvikler")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Torfinn", "Lie", "Seniorutvikler")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Thorleif", "Stene", "Seniorutvikler")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Andre", "Aubert", "Seniorutvikler")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Fred", "Inge Henden", "Seniorutvikler")));

            log.info("Preloading " + employ.saveAndFlush(new Employee("Bjørn", "Jåsund", "Leader")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Aneela", "Liaquat", "Leader")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Beatriz", "Perez", "Leader")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Bjarne", "Stensrød", "Leader")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Ingvild", "Frogner", "Leader")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Nicholas", "Larsson", "Leader")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Silje", "Eidsli", "Leader")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Wenche", "Skavnes", "Leader")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Lene", "Bråtesveen", "Leader")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Kjell", "Nybråthen", "Leader")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Nina", "Olsen", "Administrasjon")));
            log.info("Preloading " + employ.saveAndFlush(new Employee("Stig", "Falste", "Leader")));

        };
    }

    @Bean(name = "customer")
    CommandLineRunner customer(CustomerRepository customers) {
        return (args) -> {
            // save a few customers
            customers.saveAndFlush(new Customer("NAV", "Automastisk Frikort"));
            customers.saveAndFlush(new Customer("Apotek 1", "Nagara"));
            customers.saveAndFlush(new Customer("Direktoratet for e-helse ", "Digital skjema RØF, TOD"));
            customers.saveAndFlush(new Customer("Garantikassen for fiskere", "GFF ELSAM 2015"));
            customers.saveAndFlush(new Customer("NAV/Helsedirektoratet", "KUKR/SAPO"));
            customers.saveAndFlush(new Customer("Senter for pasientmedvirkning og samhandlingsforskning (SPS)", "SpsWebPage, ReConnect-App og -Web"));
            customers.saveAndFlush(new Customer("Statnett", "Responsive desegn av internettløsning"));
            customers.saveAndFlush(new Customer("Norges Forskningsråd", "Forvaltning av nettsider prosjekter"));
            customers.saveAndFlush(new Customer("Gjensidige Forsikring", "Forvaltning"));
            customers.saveAndFlush(new Customer("A-Pressen Digital Medier (Amedia)", "Nettaviser, Zett.no"));
            customers.saveAndFlush(new Customer("More Software Solutions", "Digital Skjema"));
            customers.saveAndFlush(new Customer("UDP AS", "Involvert i et internt prosjekt"));

            // fetch all customers
            log.info("== Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer customer : customers.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Optional<Customer> customer = customers.findById(0L);
            //Customer customer = customers.findById(0L);
            log.info("== Customer found with findById(0L):");
            log.info("--------------------------------");
            customer.ifPresent(value -> log.info(value.toString()));
            //log.info(customer.toString());
            log.info("");

            // fetch customers by last name
            log.info("== Customer found with findByProject('Nagara'):");
            log.info("--------------------------------------------");
            customers.findByProject("Nagara").forEach(c -> log.info(c.toString()));
            for (Customer c : customers.findByProject("Nagara")) {
                log.info(c.toString());
            }
            log.info("");
        };
    }

    @Bean(name = "partner")
    CommandLineRunner partner(PartnerRepository partners) {
        return (args) -> {
            // save a few partners
            partners.save(new Partner("Verama"));
            partners.save(new Partner("Centric"));
            partners.save(new Partner("Know IT"));
            partners.save(new Partner("EPICO-IT A/S"));
            partners.save(new Partner("Decisive"));
            partners.save(new Partner("Experis"));

            // fetch all partners
            log.info("== Partners found with findAll():");
            log.info("-------------------------------");
            for (Partner partner : partners.findAll()) {
                log.info(partner.toString());
            }
            log.info("");

            // fetch an individual partner by ID
            Optional<Partner> partner = partners.findById(37L);
            log.info("== Customer found with findById(37L):");
            log.info("--------------------------------");
            partner.ifPresent(value -> log.info(value.toString()));
            log.info("");

            // fetch partners by last name
            log.info("== Partner found with findByName('Centric'):");
            log.info("--------------------------------------------");
            partners.findByName("Centric").forEach(centric -> log.info(centric.toString()));
            for (Partner p : partners.findByName("Centric")) {
                log.info(p.toString());
            }
            log.info("");
        };
    }

    @Bean(name = "role")
    @Order(1)
    CommandLineRunner roles(RoleRepository roles) {
        return (args) -> {
            // save a few roles
            roles.saveAndFlush(new Role("GUEST"));
            roles.saveAndFlush(new Role("USER"));
            roles.saveAndFlush(new Role("STAFF"));
            roles.saveAndFlush(new Role("ADMIN"));

            // fetch all roles
            log.info("== Role found with findAll():");
            log.info("-------------------------------");
            for (Role role : roles.findAll()) {
                log.info(role.toString());
            }
            log.info("");
            // fetch roles by name
            log.info("== Role found with findByRoleName('USER'):");
            log.info("-------------------------------");
            for (Role role : roles.findByRoleName("USER")) {
                log.info(role.toString());
            }
            log.info("");
        };
    }

    @Bean(name = "user")
    @Order(2)
    CommandLineRunner user(UserRepository users, RoleRepository roles, UserRoleRepository userroles) {
        return (args) -> {

            // save a few users

            User u;
            UserRole ur;
            Long userId;
            Long rolerId;

            u = new User("guest", "password");
            //u = new User("guest", encodedString); // Base64.getEncoder().encodeToString("password".getBytes()) => cGFzc3dvcmQ=
            u = users.saveAndFlush(u);
            userId = u.getUserId();
            List<Role> roleGuest = roles.findByRoleName("GUEST");
            rolerId = roleGuest.get(0).getRoleId();
            log.info("userId: " + userId + ", rolerId: " + rolerId);
            ur = new UserRole(userId, rolerId);
            userroles.saveAndFlush(ur);

            u = new User("user", "password");
            u = users.saveAndFlush(u);
            userId = u.getUserId();
            List<Role> roleUser = roles.findByRoleName("USER");
            rolerId = roleUser.get(0).getRoleId();
            log.info("userId: " + userId + ", rolerId: " + rolerId);
            ur = new UserRole(userId, rolerId);
            userroles.saveAndFlush(ur);

            u = new User("staff", "password");
            u = users.saveAndFlush(u);
            userId = u.getUserId();
            List<Role> roleStaff = roles.findByRoleName("STAFF");
            rolerId = roleStaff.get(0).getRoleId();
            log.info("userId: " + userId + ", rolerId: " + rolerId);
            ur = new UserRole(userId, rolerId);
            userroles.saveAndFlush(ur);

            u = new User("admin", "password");
            u = users.saveAndFlush(u);
            userId = u.getUserId();
            List<Role> roleAdmin = roles.findByRoleName("ADMIN");
            rolerId = roleAdmin.get(0).getRoleId();
            log.info("userId: " + userId + ", rolerId: " + rolerId);
            ur = new UserRole(userId, rolerId);
            userroles.saveAndFlush(ur);

            u = new User("fake", "password");
            u = users.saveAndFlush(u);
            userId = u.getUserId();
            Long roleGuestId = roles.findByRoleName("GUEST").get(0).getRoleId();
            ur = new UserRole(userId, roleGuestId);
            userroles.saveAndFlush(ur);
            Long roleUserId = roles.findByRoleName("USER").get(0).getRoleId();
            ur = new UserRole(userId, roleUserId);
            userroles.saveAndFlush(ur);
            Long roleStaffId = roles.findByRoleName("STAFF").get(0).getRoleId();
            ur = new UserRole(userId, roleStaffId);
            userroles.saveAndFlush(ur);
            Long roleAdminId = roles.findByRoleName("ADMIN").get(0).getRoleId();
            ur = new UserRole(userId, roleAdminId);
            userroles.saveAndFlush(ur);
            log.info("userId: " + userId +
                    ", roleGuestId: " + roleGuestId + ", roleUserId: " + roleUserId +
                    ", roleStaffId: " + roleStaffId + ", roleAdminId: " + roleAdminId);

            // fetch all users
            log.info("== User found with findAll():");
            log.info("-------------------------------");
            for (User user : users.findAll()) {
                log.info(user.toString());
            }
            log.info("");

            // fetch all UserRole
            log.info("== UserRole found with findAll():");
            log.info("-------------------------------");
            for (UserRole userroler : userroles.findAll()) {
                log.info(userroler.toString());
            }
            log.info("");

            // fetch user by methods
            log.info("==  findByUsername(username):");
            log.info("-------------------------------");
            for (User user : users.findByUsername("user")) {
                log.info(user.toString());
            }
            log.info("");
            log.info("==  findUserByUsername(username):");
            log.info("-------------------------------");
            for (User user : users.findUserByUsername("admin")) {
                log.info(user.toString());
            }
            log.info("");
            log.info("==  findByEnable(enable):");
            log.info("-------------------------------");
            for (User user : users.findByEnable(true)) {
                log.info(user.toString());
            }
            log.info("");
            log.info("==  findByAccountNonExpired(accountNonExpired):");
            log.info("-------------------------------");
            for (User user : users.findByAccountNonExpired(true)) {
                log.info(user.toString());
            }
            log.info("");
            log.info("==  findByEnableAndAccountNonExpired(enable, accountNonExpired):");
            log.info("-------------------------------");
            for (User user : users.findByEnableAndAccountNonExpired(true,  true)) {
                log.info(user.toString());
            }
            log.info("");
            log.info("==  findQueryEnableAndAccountNonExpired(enable, accountNonExpired):");
            log.info("-------------------------------");
            for (User user : users.findQueryEnableAndAccountNonExpired(true,  true)) {
                log.info(user.toString());
            }
            log.info("");
            log.info("==  findUser(userName):");
            log.info("-------------------------------");
            for (User user : users.findUser("user")) {
                log.info(user.toString());
            }
            log.info("");
            log.info("==  findAdmin(userName):");
            log.info("-------------------------------");
            for (User user : users.findAdmin("admin")) {
                log.info(user.toString());
            }
            log.info("");

        };
    }

    @Bean(name = "comment")
    CommandLineRunner comment(PostRepository posts, PostCommentRepository postcomments,
                              PostDetailRepository postdetails, PostTagRepository posttags) {
        return (args) -> {

            Post post;
            PostComment postcomment;
            PostDetail postdetail;
            PostTag postTag;

        //Create Post 1
            post = new Post("Post 1 - Mellom oppdrag");
            post = posts.saveAndFlush(post);

        //PostComment save automatic in database
            postcomment = new PostComment("review1");
            //postcomment.setPost(post);
            post.getComments().add(postcomment);
        //PostComment save in database via Post
            post = posts.saveAndFlush(post);
        //Save PostDetail in database
            postdetail = new PostDetail("Pedro");
            //postdetail.setPost(post);
            //postdetails.saveAndFlush(postdetail); //detached entity passed to persist




        //PostComment save automatic in database
            postcomment = new PostComment("review2");
            //postcomment.setPost(post);
            post.getComments().add(postcomment);
        //PostComment and PostDetail save in database via Post
            post = posts.saveAndFlush(post);
        //Save PostDetail in database
            postdetail = new PostDetail("Pedro2");
            //postdetail.setPost(post);
            //postdetails.saveAndFlush(postdetail); //detached entity passed to persist


        //Create PostTag
            Set<Post> postset = new LinkedHashSet<>();
            postset.add(post);
            postTag = new PostTag("Develop", postset);
            postTag = posttags.saveAndFlush(postTag);


            List<PostTag> tags = posttags.findAll(); //comments is null??????



            // fetch all posts
            log.info("== Post found with findAll():");
            log.info("-------------------------------");
            for (Post p : posts.findAll()) {
                log.info(p.toString());
            }
            log.info("");
            // fetch all postcomments
            log.info("== PostComment found with findAll():");
            log.info("-------------------------------");
            for (PostComment pc3 : postcomments.findAll()) {
                log.info(pc3.toString());
            }
            log.info("");
            // fetch all postdetails
            log.info("== PostDetail found with findAll():");
            log.info("-------------------------------");
            for (PostDetail pd : postdetails.findAll()) {
                log.info(pd.toString());
            }
            log.info("");
            // fetch all posttags
            log.info("== PostTags found with findAll():");
            log.info("-------------------------------");
            for (PostTag pt : posttags.findAll()) {
                log.info("PostTag: " + pt.toString());
                //Caused by: org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role: no.agitec.fagaften.mellom.oppdrag.domain.comment.PostTag.posts, could not initialize proxy - no Session
            }
            log.info("");

        };
    }

    @Bean(name = "store")
    CommandLineRunner store(CompanyRepository companies, ImageRepository images, ImporterRepository importers,
                           ProductRepsitory products, WarehouseProductInforRepository warehouseProducts) {
        return (args) -> {

            companies.saveAndFlush(new Company("Agitec AS"));
            companies.saveAndFlush(new Company("Scienta AS"));
            companies.saveAndFlush(new Company("Mattilsynet, Oslo"));
            companies.saveAndFlush(new Company("NAV"));
            // fetch all companies
            log.info("== Company found with findAll():");
            log.info("-------------------------------");
            for (Company company : companies.findAll()) {
                log.info(company.toString());
            }
            log.info("");

            importers.saveAndFlush(new Importer("importer-1"));
            importers.saveAndFlush(new Importer("importer-2"));
            importers.saveAndFlush(new Importer("importer-3"));
            importers.saveAndFlush(new Importer("importer-4"));
            // fetch all images
            log.info("== Importer found with findAll():");
            log.info("-------------------------------");
            for (Importer importer : importers.findAll()) {
                log.info(importer.toString());
            }


            //Problems
            Set<Long> versions = new LinkedHashSet<>();
            versions.add(1L);
            Optional<Company> company = companies.findById(1L);
            Optional<Importer> importer = importers.findById(1L);
            /*
            Caused by: org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: NULL not allowed for column "COMPANY_ID"; SQL statement:
            insert into product (code, company_id, importer_id, name, quantity, version, id) values (?, ?, ?, ?, ?, ?, ?) [23502-200]
            Product product = products.saveAndFlush(new Product("code-0", "product-0", 1, 1));
            */
            Product product = products.saveAndFlush(new Product("code-1", company.get(), importer.get(), "product-1", 1, 1));
            //Method threw 'org.hibernate.LazyInitializationException' exception. Cannot evaluate no.agitec.fagaften.mellom.oppdrag.store.Product.toString()
            WarehouseProductInfo warehouseProductInfo = warehouseProducts.save(new WarehouseProductInfo(1, product));
            //http://www.agitec.no/css/agitec.svg
            Image image = images.save(new Image("agitec.svg", 1, product, versions));
            products.flush();


            company = companies.findById(2L);
            importer = importers.findById(2L);
            product = products.saveAndFlush(new Product("code-2", company.get(), importer.get(), "product-2", 2, 1));
            warehouseProductInfo = warehouseProducts.saveAndFlush(new WarehouseProductInfo(2, product));
            //https://scienta.no/wp-content/uploads/2017/03/scienta_logo.png
            image = images.saveAndFlush(new Image("scienta_logo.png", 2, product, versions));

            company = companies.findById(3L);
            importer = importers.findById(3L);
            product = products.saveAndFlush(new Product("code-3", company.get(), importer.get(), "product-3", 3, 1));
            warehouseProductInfo = warehouseProducts.saveAndFlush(new WarehouseProductInfo(3, product));
            //https://vaganavisa.no/media/cache/frontend_article_lg/bundles/global/uploads/articles/6/Mattilsynet.4089.jpg
            image = images.saveAndFlush(new Image("Mattilsynet.4089.jpg", 3, product, versions));

            company = companies.findById(4L);
            importer = importers.findById(4L);
            product = products.saveAndFlush(new Product("code-4", company.get(), importer.get(), "product-4", 4, 1));
            warehouseProductInfo = warehouseProducts.saveAndFlush(new WarehouseProductInfo(4, product));
            //https://www.nav.no/dekoratoren/media/nav-logo-red.svg
            image = images.saveAndFlush(new Image("nav-logo-red.svg", 4, product, versions));

            /*
            log.info("== Product found with findAll():");
            log.info("-------------------------------");
            for (Product p : products.findAll()) {
                //log.info(p.toString());
            }
            log.info("");

            // fetch all images
            log.info("== WarehouseProductInfo found with findAll():");
            log.info("-------------------------------");
            for (WarehouseProductInfo wpinfo : warehouseProducts.findAll()) {
                //log.info(wpinfo.toString());
            }

            // fetch all images
            log.info("== Image found with findAll():");
            log.info("-------------------------------");
            for (Image i : images.findAll()) {
                //log.info(i.toString());
            }
            log.info("");
            */
        };
    }

}
