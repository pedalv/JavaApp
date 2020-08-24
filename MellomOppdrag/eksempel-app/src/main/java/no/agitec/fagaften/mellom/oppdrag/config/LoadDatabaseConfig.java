package no.agitec.fagaften.mellom.oppdrag.config;

import lombok.extern.slf4j.Slf4j;
import no.agitec.fagaften.mellom.oppdrag.domain.*;
import no.agitec.fagaften.mellom.oppdrag.domain.comment.*;
import no.agitec.fagaften.mellom.oppdrag.domain.store.*;
import no.agitec.fagaften.mellom.oppdrag.repository.*;
import no.agitec.fagaften.mellom.oppdrag.repository.comment.*;
import no.agitec.fagaften.mellom.oppdrag.repository.store.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    /**
     * OneToMany   - Post          - @OneToMany: One Post has many Comments
     * ManyToOne   - Comment   - @ManyToOne: Many Comments has one Post
     * OneToOne    - Detail    - @OneToOne: One Detail has one Post - save in database automatic Post, Comment n
     * ManyToMany  - Tag           - @ManyToMany: Many Tags has many Posts
     *             - Post          - @ManyToMany: Many Posts has many Tags
     *
     * Explicitly specifying FetchType.LAZY in either @OneToOne or @ManyToOne annotation
     *
     * Explicitly Specifying FetchType.EAGER explicitly in @OneToMany or @ManyToMany annotations
     *
     * @param posts
     * @param comments
     * @param details
     * @param posttags
     * @return
     */
    @Bean(name = "comment")
    CommandLineRunner comment(PostRepository posts,
                              DetailRepository details,
                              CommentRepository comments, PostCommentRepository postcomments,
                              TagRepository tags, PostTagRepository posttags) {
        return (args) -> {

            Post post;
            Comment comment;
            Tag tag;
            Detail detail;
            PostTag postTag;
            PostComment postComment;

        // Create Tag - developer
            tag = new Tag("Developer");
        //Save in database
            tag = tags.save(tag);
            // Create Tag - Leder
            tag = new Tag("Leder");
        //Save in database
            tag = tags.save(tag);
        //..
        // fetch all tags
            log.info("== tAG found with findAll():");
            log.info("-------------------------------");
            for (Tag t : tags.findAll()) {
                log.info(t.toString());
                //Tag(id=1, name=Developer)
                //Tag(id=2, name=Leder)
            }
            Optional<Tag> tagDeveloper = tags.findById(1L); //Developer
            tagDeveloper =    tags.findByName("Developer");
            Optional<Tag> tagLeder = tags.findById(2L); //Developer


        //Create Post 1 - @OneToMany: One Post has many Comments
            post = new Post(
                    "Post 1 - Mellom oppdrag",
                    "Her er det sterk fokus på å få alle ut i oppdrag og i mellomtiden jobbes det med faglig utvikling og kompetanseheving.");
        //Create Detail - @OneToOne: One Detail has one Post
            detail = new Detail("Pedro");
            detail.setPost(post);
        //Save in database automatic Post, Comment n
            detail = details.saveAndFlush(detail);
        //Create PostTag
            postTag = new PostTag(post.getId(), tagDeveloper.get().getId());
        //Save PostTag
            postTag = posttags.saveAndFlush(postTag);

        // fetch all posts
            log.info("== Post found with findAll():");
            log.info("-------------------------------");
            for (Post p : posts.findAll()) {
                log.info(p.toString());
                //Post(
                // id=1,
                // title=Post 1 - Mellom oppdrag,
                // content=Her er det sterk fokus på å få alle ut i oppdrag og i mellomtiden jobbes det med faglig utvikling og kompetanseheving.,
                // comments=[],
                // tags=[Tag(id=1, name=Developer)])
            }

        //Create and save Comment 1 - @ManyToOne: Many Comments has one Post
            comment = new Comment("review1");
            comment = comments.saveAndFlush(comment);
        //Create and save PostComment 1
            postComment = new PostComment(post.getId(), comment.getId());
            postcomments.saveAndFlush(postComment);
        //Create and save Comment 2
            comment = new Comment("review2");
            comment = comments.saveAndFlush(comment);
        //Create and save PostComment 2
            postComment = new PostComment(post.getId(), comment.getId());
            postcomments.saveAndFlush(postComment);
        //Create and save Comment 3
            comment = new Comment("review3");
            comment = comments.saveAndFlush(comment);
        //Create and save PostComment 3
            postComment = new PostComment(post.getId(), comment.getId());
            postcomments.saveAndFlush(postComment);
        //...

        // fetch all posts
            log.info("== Post found with findAll():");
            log.info("-------------------------------");
            for (Post p : posts.findAll()) {
                log.info(p.toString());
                //Post(
                // id=1,
                // title=Post 1 - Mellom oppdrag,
                // content=Her er det sterk fokus på å få alle ut i oppdrag og i mellomtiden jobbes det med faglig utvikling og kompetanseheving.,
                // comments=[Comment(id=1, review=review1), Comment(id=2, review=review2), Comment(id=3, review=review3)],
                // tags=[Tag(id=1, name=Developer)])
            }


       //CREATE MORE COMMENT IN SAME POST AND DETAIL
            post = posts.findAll().get(0); //"Post 1 - Mellom oppdrag"
        //Create and save Comment n+1 - @ManyToOne: Many Comments has one Post
            comment = new Comment("review4");
            comment = comments.saveAndFlush(comment);
        //Create and save PostComment 4
            postComment = new PostComment(post.getId(), comment.getId());
            postcomments.saveAndFlush(postComment);
        //Create and save Comment 5 - @ManyToOne: Many Comments has one Post
            comment = new Comment("review5");
            comment = comments.saveAndFlush(comment);
        //Create and save PostComment 5
            postComment = new PostComment(post.getId(), comment.getId());
            postcomments.saveAndFlush(postComment);

       //TIPS OG RÅD
            //Method threw 'org.hibernate.LazyInitializationException' exception. Cannot evaluate no.agitec.fagaften.mellom.oppdrag.domain.comment.Post$HibernateProxy$NgEWEShs.toString()
            //https://stackoverflow.com/questions/40266770/spring-jpa-bi-directional-cannot-evaluate-tostring
            //https://stackoverflow.com/questions/47442454/how-to-avoid-initializing-hibernateproxy-when-invoking-tostring-on-it
            //https://stackoverflow.com/questions/42632648/lazyinitializationexception-trying-to-get-lazy-initialized-instance
            //https://arnoldgalovics.com/lazyinitializationexception-demystified/
            //https://stackoverflow.com/questions/35997541/getting-org-hibernate-lazyinitializationexception-exceptions-after-retrieving/36168024


         //Create Tag - Customer
            tag = new Tag("Customer");
         //Save in database
            tag = tags.save(tag);
        //Create PostTag
            postTag = new PostTag(post.getId(), tags.findByName("Customer").get().getId());
        //Save PostTag
            postTag = posttags.saveAndFlush(postTag);
        //fetch post updated
            post = posts.findAll().get(0); //"Post 1 - Mellom oppdrag"
            detail = details.findAll().get(0);
            Long id = detail.getId();
            LocalDateTime createdOn = detail.getCreatedOn();
            String createdBy = detail.getCreatedBy();
            Post post1 = detail.getPost();
System.out.println("P:" + post1.toString());
System.out.println("Pid:" + post1.getId());
System.out.println("Ptitle:" + post1.getTitle());
System.out.println("Pcontent:" + post1.getContent());
System.out.println("Pcomments:" + post1.getComments().toString());
System.out.println("Ptags:" + post1.getTags().toString());

            // fetch all posts
            log.info("== Post found with findAll():");
            log.info("-------------------------------");
            for (Post p : posts.findAll()) {
                log.info(p.toString());
                //Post(
                // id=1,
                // title=Post 1 - Mellom oppdrag, content=Her er det sterk fokus på å få alle ut i oppdrag og i mellomtiden jobbes det med faglig utvikling og kompetanseheving.,
                // comments=[Comment(id=1, review=review1), Comment(id=2, review=review2), Comment(id=3, review=review3), Comment(id=4, review=review4), Comment(id=5, review=review5)],
                // tags=[Tag(id=3, name=Customer), Tag(id=1, name=Developer)])
            }
            log.info("");
            // fetch all comments
            log.info("== Comment found with findAll():");
            log.info("-------------------------------");
            for (Comment c : comments.findAll()) {
                log.info(c.toString());
                //Comment(id=1, review=review1)
                //Comment(id=2, review=review2)
                //Comment(id=3, review=review3)
                //Comment(id=4, review=review4)
                //Comment(id=5, review=review5)
            }
            log.info("");
            // fetch all postcomments
            log.info("== PostComment found with findAll():");
            log.info("-------------------------------");
            for (PostComment pc : postcomments.findAll()) {
                log.info(pc.toString());
                //PostComment(id=1, postId=1, commentId=1)
                //PostComment(id=2, postId=1, commentId=2)
                //PostComment(id=3, postId=1, commentId=3)
                //PostComment(id=4, postId=1, commentId=4)
                //PostComment(id=5, postId=1, commentId=5)
            }
            log.info("");
            // fetch all details
            log.info("== Detail found with findAll():");
            log.info("-------------------------------");
            for (Detail d : details.findAll()) {
                log.info(d.toString());
                // Detail(
                // id=1,
                // createdOn=2020-08-24T14:07:43.789564,
                // createdBy=Pedro,
                // post=Post(
                // id=1,
                // title=Post 1 - Mellom oppdrag,
                // content=Her er det sterk fokus på å få alle ut i oppdrag og i mellomtiden jobbes det med faglig utvikling og kompetanseheving.,
                // comments=[Comment(id=1, review=review1), Comment(id=1, review=review1), Comment(id=2, review=review2), Comment(id=2, review=review2), Comment(id=3, review=review3), Comment(id=3, review=review3), Comment(id=4, review=review4), Comment(id=4, review=review4), Comment(id=5, review=review5), Comment(id=5, review=review5)],
                // tags=[Tag(id=3, name=Customer), Tag(id=1, name=Developer)]))
            }
            log.info("");
            // fetch all tags
            log.info("== Tag found with findAll():");
            log.info("-------------------------------");
            for (Tag t : tags.findAll()) {
                log.info(t.toString());
                //Tag(id=1, name=Developer)
                //Tag(id=2, name=Leder)
                //Tag(id=3, name=Customer)
            }
            log.info("");
            // fetch all posttags
            log.info("== PostTag found with findAll():");
            log.info("-------------------------------");
            for (PostTag pt : posttags.findAll()) {
                log.info("PostTag: " + pt.toString());
                //PostTag: PostTag(id=1, postId=1, tagId=1)
                //PostTag: PostTag(id=2, postId=1, tagId=3)
            }
            log.info("");
        };
    }



    /**
     *
     * OneToMany   - Product               - @OneToMany: One Product has many images
     *             - Image                 - @OneToMany: One Image has many versions
     *             - VersionI              - OneToMany: One Version has many SubVersions
     * ManyToOne   - Product               - @ManyToOne: Many Products has a company
     *                                     - @ManyToOne: Many Products has a importer
     *             - Image                 - @ManyToOne: Many Images has a product
     *             - SubVersionI           - @ManyToOne: Many SubVersionI has a version
     *             - VersionI              - @ManyToOne: Many Versions has one image
     * OneToOne    - Product               - @OneToOne: One Product has a warehouseProductInfo
     *             - WarehouseProductInfo  - @OneToOne: One WarehouseProductInfos has a product
     * ManyToMany  - none
     *
     * @param companies
     * @param images
     * @param importers
     * @param products
     * @param warehouseProducts
     * @param subversions
     * @param versions
     * @return
     */
    @Bean(name = "store")
    CommandLineRunner store(CompanyRepository companies, ImageRepository images, ImporterRepository importers,
                            ProductRepsitory products, WarehouseProductInforRepository warehouseProducts,
                            SubVersionRepository subversions, VersionRepository versions) {
        return (args) -> {

            Optional<Company> company;
            Optional<Importer> importer;
            Product product;
            Image image;
            Version version;
            SubVersion subversion;
            WarehouseProductInfo warehouseProductInfo;

            company = Optional.of(new Company("Agitec AS"));
            companies.saveAndFlush(company.get());
            company = Optional.of(new Company("Scienta AS"));
            companies.saveAndFlush(company.get());
            company = Optional.of(new Company("Mattilsynet, Oslo"));
            companies.saveAndFlush(company.get());
            company = Optional.of(new Company("NAV"));
            companies.saveAndFlush(company.get());
            // fetch all companies
            log.info("== Company found with findAll():");
            log.info("-------------------------------");
            for (Company c : companies.findAll()) {
                log.info(c.toString());
                //Company(id=1, name=Agitec AS)
                //Company(id=2, name=Scienta AS)
                //Company(id=3, name=Mattilsynet, Oslo)
                //Company(id=4, name=NAV)
            }
            log.info("");

            importer = Optional.of(new Importer("importer-1"));
            importers.saveAndFlush(importer.get());
            importer = Optional.of(new Importer("importer-2"));
            importers.saveAndFlush(importer.get());
            importer = Optional.of(new Importer("importer-3"));
            importers.saveAndFlush(importer.get());
            importer = Optional.of(new Importer("importer-4"));
            importers.saveAndFlush(importer.get());
            // fetch all importers
            log.info("== Importer found with findAll():");
            log.info("-------------------------------");
            for (Importer i : importers.findAll()) {
                log.info(i.toString());
                //Importer(id=1, name=importer-1)
                //Importer(id=2, name=importer-2)
                //Importer(id=3, name=importer-3)
                //Importer(id=4, name=importer-4)
            }

            company = companies.findById(1L);
            importer = importers.findById(1L);
            //http://www.agitec.no/css/agitec.svg
            image = new Image("agitec.svg", 1);
            subversion = new SubVersion("image-code-agitec");
            version = new Version();
            version.addSubVersion(subversion);
            image.addVersion(version);
            warehouseProductInfo = new WarehouseProductInfo(1);
            product = new Product("code-1");
            product.setCompany(company.get());
            product.setImporter(importer.get());
            product.addImage(image);
            product.addWarehouse(warehouseProductInfo);
            product = products.saveAndFlush(product);

            company = companies.findById(2L);
            importer = importers.findById(2L);
            //https://scienta.no/wp-content/uploads/2017/03/scienta_logo.png
            image = new Image("scienta_logo.png", 2);
            subversion = new SubVersion("image-code-sciente");
            version = new Version();
            version.addSubVersion(subversion);
            image.addVersion(version);
            warehouseProductInfo = new WarehouseProductInfo(2);
            product = new Product("code-2");
            product.setCompany(company.get());
            product.setImporter(importer.get());
            product.addImage(image);
            product.addWarehouse(warehouseProductInfo);
            product = products.saveAndFlush(product);

            company = companies.findById(3L);
            importer = importers.findById(3L);
            //https://vaganavisa.no/media/cache/frontend_article_lg/bundles/global/uploads/articles/6/Mattilsynet.4089.jpg
            image = new Image("Mattilsynet.4089.jpg", 3);
            subversion = new SubVersion("image-code-mattilsynet");
            version = new Version();
            version.addSubVersion(subversion);
            image.addVersion(version);
            warehouseProductInfo = new WarehouseProductInfo(3);
            product = new Product("code-3");
            product.setCompany(company.get());
            product.setImporter(importer.get());
            product.addImage(image);
            product.addWarehouse(warehouseProductInfo);
            product = products.saveAndFlush(product);

            company = companies.findById(4L);
            importer = importers.findById(4L);
            //https://www.nav.no/dekoratoren/media/nav-logo-red.svg
            image = new Image("nav-logo-red.svg", 4);
            subversion = new SubVersion("image-code-nav");
            version = new Version();
            version.addSubVersion(subversion);
            image.addVersion(version);
            warehouseProductInfo = new WarehouseProductInfo(4);
            product = new Product("code-4");
            product.setCompany(company.get());
            product.setImporter(importer.get());
            product.addImage(image);
            product.addWarehouse(warehouseProductInfo);
            product = products.saveAndFlush(product);


            // fetch all companies
            log.info("== Company found with findAll():");
            log.info("-------------------------------");
            for (Company c : companies.findAll()) {
                log.info(c.toString());
                //Company(id=1, name=Agitec AS)
                //Company(id=2, name=Scienta AS)
                //Company(id=3, name=Mattilsynet, Oslo)
                //Company(id=4, name=NAV)
            }
            log.info("");
            // fetch all importers
            log.info("== Importer found with findAll():");
            log.info("-------------------------------");
            for (Importer i : importers.findAll()) {
                log.info(i.toString());
                //Importer(id=1, name=importer-1)
                //Importer(id=2, name=importer-2)
                //Importer(id=3, name=importer-3)
                //Importer(id=4, name=importer-4)
            }
            log.info("");
            // fetch all products
            log.info("== Product found with findAll():");
            log.info("-------------------------------");
            for (Product p : products.findAll()) {
                log.info(p.toString());
                //Product(id=1, name=null, code=code-1, quantity=null, version=0, company=Company(id=1, name=Agitec AS), warehouseProductInfo=WarehouseProductInfo(id=1, quantity=1, product_id=1), importer=Importer(id=1, name=importer-1), images=[])
                //Product(id=2, name=null, code=code-2, quantity=null, version=0, company=Company(id=2, name=Scienta AS), warehouseProductInfo=WarehouseProductInfo(id=2, quantity=2, product_id=2), importer=Importer(id=2, name=importer-2), images=[])
                //Product(id=3, name=null, code=code-3, quantity=null, version=0, company=Company(id=3, name=Mattilsynet, Oslo), warehouseProductInfo=WarehouseProductInfo(id=3, quantity=3, product_id=3), importer=Importer(id=3, name=importer-3), images=[])
                //Product(id=4, name=null, code=code-4, quantity=null, version=0, company=Company(id=4, name=NAV), warehouseProductInfo=WarehouseProductInfo(id=4, quantity=4, product_id=4), importer=Importer(id=4, name=importer-4), images=[])
            }
            log.info("");
            // fetch all warehouseProductsInfo
            log.info("== WarehouseProductInfo found with findAll():");
            log.info("-------------------------------");
            for (WarehouseProductInfo wpinfo : warehouseProducts.findAll()) {
                log.info(wpinfo.toString());
                //WarehouseProductInfo(id=1, quantity=1, product_id=1)
                //WarehouseProductInfo(id=2, quantity=2, product_id=2)
                //WarehouseProductInfo(id=3, quantity=3, product_id=3)
                //WarehouseProductInfo(id=4, quantity=4, product_id=4)
            }
            log.info("");
            // fetch all images
            log.info("== Image found with findAll():");
            log.info("-------------------------------");
            for (Image i : images.findAll()) {
                log.info(i.toString());
                //Image(id=1, name=agitec.svg, index=1, product=null, versions=[])
                //Image(id=2, name=scienta_logo.png, index=2, product=null, versions=[])
                //Image(id=3, name=Mattilsynet.4089.jpg, index=3, product=null, versions=[])
                //Image(id=4, name=nav-logo-red.svg, index=4, product=null, versions=[])

            }
            log.info("");
            // fetch all versions
            log.info("== Version found with findAll():");
            log.info("-------------------------------");
            for (Version v : versions.findAll()) {
                log.info(v.toString());
                //Version(id=1, type=null, image=null, subVersions=[])
                //Version(id=2, type=null, image=null, subVersions=[])
                //Version(id=3, type=null, image=null, subVersions=[])
                //Version(id=4, type=null, image=null, subVersions=[])
            }
            log.info("");
            // fetch all subversions
            log.info("== SubVersion found with findAll():");
            log.info("-------------------------------");
            for (SubVersion subv : subversions.findAll()) {
                log.info(subv.toString());
                //SubVersion(id=1, code=image-code-agitec, version=null)
                //SubVersion(id=2, code=image-code-sciente, version=null)
                //SubVersion(id=3, code=image-code-mattilsynet, version=null)
                //SubVersion(id=4, code=image-code-nav, version=null)
            }
            log.info("");

        };
    }

}
