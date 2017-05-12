package com.hanv.ads.web.rest;

import com.hanv.ads.AdsApp;

import com.hanv.ads.domain.Post;
import com.hanv.ads.repository.PostRepository;
import com.hanv.ads.service.dto.PostDTO;
import com.hanv.ads.service.mapper.PostMapper;
import com.hanv.ads.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.ZoneOffset;
import java.time.ZoneId;
import java.util.List;

import static com.hanv.ads.web.rest.TestUtil.sameInstant;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the PostResource REST controller.
 *
 * @see PostResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdsApp.class)
public class PostResourceIntTest {

    private static final String DEFAULT_MESSAGE = "AAAAAAAAAA";
    private static final String UPDATED_MESSAGE = "BBBBBBBBBB";

    private static final String DEFAULT_PAGE_ID = "AAAAAAAAAA";
    private static final String UPDATED_PAGE_ID = "BBBBBBBBBB";

    private static final String DEFAULT_PAGE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_PAGE_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_CATEGORY = "AAAAAAAAAA";
    private static final String UPDATED_CATEGORY = "BBBBBBBBBB";

    private static final String DEFAULT_CATEGORIES = "AAAAAAAAAA";
    private static final String UPDATED_CATEGORIES = "BBBBBBBBBB";

    private static final String DEFAULT_LINK = "AAAAAAAAAA";
    private static final String UPDATED_LINK = "BBBBBBBBBB";

    private static final String DEFAULT_PICTURE = "AAAAAAAAAA";
    private static final String UPDATED_PICTURE = "BBBBBBBBBB";

    private static final String DEFAULT_FULL_PICTURE = "AAAAAAAAAA";
    private static final String UPDATED_FULL_PICTURE = "BBBBBBBBBB";

    private static final Long DEFAULT_SHARE_COUNT = 20L;
    private static final Long UPDATED_SHARE_COUNT = 19L;

    private static final Long DEFAULT_REACTIONS_COUNT = 20L;
    private static final Long UPDATED_REACTIONS_COUNT = 19L;

    private static final Long DEFAULT_COMMENT_COUNT = 20L;
    private static final Long UPDATED_COMMENT_COUNT = 19L;

    private static final Long DEFAULT_LIKE_COUNT = 20L;
    private static final Long UPDATED_LIKE_COUNT = 19L;

    private static final Long DEFAULT_LOVE_COUNT = 20L;
    private static final Long UPDATED_LOVE_COUNT = 19L;

    private static final Long DEFAULT_WOW_COUNT = 20L;
    private static final Long UPDATED_WOW_COUNT = 19L;

    private static final Long DEFAULT_HAHA_COUNT = 20L;
    private static final Long UPDATED_HAHA_COUNT = 19L;

    private static final Long DEFAULT_SAD_COUNT = 20L;
    private static final Long UPDATED_SAD_COUNT = 19L;

    private static final Long DEFAULT_ANGRY_COUNT = 20L;
    private static final Long UPDATED_ANGRY_COUNT = 19L;

    private static final Long DEFAULT_THANKFUL_COUNT = 20L;
    private static final Long UPDATED_THANKFUL_COUNT = 19L;

    private static final ZonedDateTime DEFAULT_CREATED_DATE = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_CREATED_DATE = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final String DEFAULT_CREATED_BY = "AAAAAAAAAA";
    private static final String UPDATED_CREATED_BY = "BBBBBBBBBB";

    private static final ZonedDateTime DEFAULT_MODIFIED_DATE = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_MODIFIED_DATE = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final String DEFAULT_MODIFIED_BY = "AAAAAAAAAA";
    private static final String UPDATED_MODIFIED_BY = "BBBBBBBBBB";

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restPostMockMvc;

    private Post post;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        PostResource postResource = new PostResource(postRepository, postMapper);
        this.restPostMockMvc = MockMvcBuilders.standaloneSetup(postResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Post createEntity(EntityManager em) {
        Post post = new Post()
            .message(DEFAULT_MESSAGE)
            .pageId(DEFAULT_PAGE_ID)
            .pageName(DEFAULT_PAGE_NAME)
            .category(DEFAULT_CATEGORY)
            .categories(DEFAULT_CATEGORIES)
            .link(DEFAULT_LINK)
            .picture(DEFAULT_PICTURE)
            .fullPicture(DEFAULT_FULL_PICTURE)
            .shareCount(DEFAULT_SHARE_COUNT)
            .reactionsCount(DEFAULT_REACTIONS_COUNT)
            .commentCount(DEFAULT_COMMENT_COUNT)
            .likeCount(DEFAULT_LIKE_COUNT)
            .loveCount(DEFAULT_LOVE_COUNT)
            .wowCount(DEFAULT_WOW_COUNT)
            .hahaCount(DEFAULT_HAHA_COUNT)
            .sadCount(DEFAULT_SAD_COUNT)
            .angryCount(DEFAULT_ANGRY_COUNT)
            .thankfulCount(DEFAULT_THANKFUL_COUNT)
            .createdDate(DEFAULT_CREATED_DATE)
            .createdBy(DEFAULT_CREATED_BY)
            .modifiedDate(DEFAULT_MODIFIED_DATE)
            .modifiedBy(DEFAULT_MODIFIED_BY);
        return post;
    }

    @Before
    public void initTest() {
        post = createEntity(em);
    }

    @Test
    @Transactional
    public void createPost() throws Exception {
        int databaseSizeBeforeCreate = postRepository.findAll().size();

        // Create the Post
        PostDTO postDTO = postMapper.toDto(post);
        restPostMockMvc.perform(post("/api/posts")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(postDTO)))
            .andExpect(status().isCreated());

        // Validate the Post in the database
        List<Post> postList = postRepository.findAll();
        assertThat(postList).hasSize(databaseSizeBeforeCreate + 1);
        Post testPost = postList.get(postList.size() - 1);
        assertThat(testPost.getMessage()).isEqualTo(DEFAULT_MESSAGE);
        assertThat(testPost.getPageId()).isEqualTo(DEFAULT_PAGE_ID);
        assertThat(testPost.getPageName()).isEqualTo(DEFAULT_PAGE_NAME);
        assertThat(testPost.getCategory()).isEqualTo(DEFAULT_CATEGORY);
        assertThat(testPost.getCategories()).isEqualTo(DEFAULT_CATEGORIES);
        assertThat(testPost.getLink()).isEqualTo(DEFAULT_LINK);
        assertThat(testPost.getPicture()).isEqualTo(DEFAULT_PICTURE);
        assertThat(testPost.getFullPicture()).isEqualTo(DEFAULT_FULL_PICTURE);
        assertThat(testPost.getShareCount()).isEqualTo(DEFAULT_SHARE_COUNT);
        assertThat(testPost.getReactionsCount()).isEqualTo(DEFAULT_REACTIONS_COUNT);
        assertThat(testPost.getCommentCount()).isEqualTo(DEFAULT_COMMENT_COUNT);
        assertThat(testPost.getLikeCount()).isEqualTo(DEFAULT_LIKE_COUNT);
        assertThat(testPost.getLoveCount()).isEqualTo(DEFAULT_LOVE_COUNT);
        assertThat(testPost.getWowCount()).isEqualTo(DEFAULT_WOW_COUNT);
        assertThat(testPost.getHahaCount()).isEqualTo(DEFAULT_HAHA_COUNT);
        assertThat(testPost.getSadCount()).isEqualTo(DEFAULT_SAD_COUNT);
        assertThat(testPost.getAngryCount()).isEqualTo(DEFAULT_ANGRY_COUNT);
        assertThat(testPost.getThankfulCount()).isEqualTo(DEFAULT_THANKFUL_COUNT);
        assertThat(testPost.getCreatedDate()).isEqualTo(DEFAULT_CREATED_DATE);
        assertThat(testPost.getCreatedBy()).isEqualTo(DEFAULT_CREATED_BY);
        assertThat(testPost.getModifiedDate()).isEqualTo(DEFAULT_MODIFIED_DATE);
        assertThat(testPost.getModifiedBy()).isEqualTo(DEFAULT_MODIFIED_BY);
    }

    @Test
    @Transactional
    public void createPostWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = postRepository.findAll().size();

        // Create the Post with an existing ID
        post.setId(1L);
        PostDTO postDTO = postMapper.toDto(post);

        // An entity with an existing ID cannot be created, so this API call must fail
        restPostMockMvc.perform(post("/api/posts")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(postDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Alice in the database
        List<Post> postList = postRepository.findAll();
        assertThat(postList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllPosts() throws Exception {
        // Initialize the database
        postRepository.saveAndFlush(post);

        // Get all the postList
        restPostMockMvc.perform(get("/api/posts?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(post.getId().intValue())))
            .andExpect(jsonPath("$.[*].message").value(hasItem(DEFAULT_MESSAGE.toString())))
            .andExpect(jsonPath("$.[*].pageId").value(hasItem(DEFAULT_PAGE_ID.toString())))
            .andExpect(jsonPath("$.[*].pageName").value(hasItem(DEFAULT_PAGE_NAME.toString())))
            .andExpect(jsonPath("$.[*].category").value(hasItem(DEFAULT_CATEGORY.toString())))
            .andExpect(jsonPath("$.[*].categories").value(hasItem(DEFAULT_CATEGORIES.toString())))
            .andExpect(jsonPath("$.[*].link").value(hasItem(DEFAULT_LINK.toString())))
            .andExpect(jsonPath("$.[*].picture").value(hasItem(DEFAULT_PICTURE.toString())))
            .andExpect(jsonPath("$.[*].fullPicture").value(hasItem(DEFAULT_FULL_PICTURE.toString())))
            .andExpect(jsonPath("$.[*].shareCount").value(hasItem(DEFAULT_SHARE_COUNT.intValue())))
            .andExpect(jsonPath("$.[*].reactionsCount").value(hasItem(DEFAULT_REACTIONS_COUNT.intValue())))
            .andExpect(jsonPath("$.[*].commentCount").value(hasItem(DEFAULT_COMMENT_COUNT.intValue())))
            .andExpect(jsonPath("$.[*].likeCount").value(hasItem(DEFAULT_LIKE_COUNT.intValue())))
            .andExpect(jsonPath("$.[*].loveCount").value(hasItem(DEFAULT_LOVE_COUNT.intValue())))
            .andExpect(jsonPath("$.[*].wowCount").value(hasItem(DEFAULT_WOW_COUNT.intValue())))
            .andExpect(jsonPath("$.[*].hahaCount").value(hasItem(DEFAULT_HAHA_COUNT.intValue())))
            .andExpect(jsonPath("$.[*].sadCount").value(hasItem(DEFAULT_SAD_COUNT.intValue())))
            .andExpect(jsonPath("$.[*].angryCount").value(hasItem(DEFAULT_ANGRY_COUNT.intValue())))
            .andExpect(jsonPath("$.[*].thankfulCount").value(hasItem(DEFAULT_THANKFUL_COUNT.intValue())))
            .andExpect(jsonPath("$.[*].createdDate").value(hasItem(sameInstant(DEFAULT_CREATED_DATE))))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY.toString())))
            .andExpect(jsonPath("$.[*].modifiedDate").value(hasItem(sameInstant(DEFAULT_MODIFIED_DATE))))
            .andExpect(jsonPath("$.[*].modifiedBy").value(hasItem(DEFAULT_MODIFIED_BY.toString())));
    }

    @Test
    @Transactional
    public void getPost() throws Exception {
        // Initialize the database
        postRepository.saveAndFlush(post);

        // Get the post
        restPostMockMvc.perform(get("/api/posts/{id}", post.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(post.getId().intValue()))
            .andExpect(jsonPath("$.message").value(DEFAULT_MESSAGE.toString()))
            .andExpect(jsonPath("$.pageId").value(DEFAULT_PAGE_ID.toString()))
            .andExpect(jsonPath("$.pageName").value(DEFAULT_PAGE_NAME.toString()))
            .andExpect(jsonPath("$.category").value(DEFAULT_CATEGORY.toString()))
            .andExpect(jsonPath("$.categories").value(DEFAULT_CATEGORIES.toString()))
            .andExpect(jsonPath("$.link").value(DEFAULT_LINK.toString()))
            .andExpect(jsonPath("$.picture").value(DEFAULT_PICTURE.toString()))
            .andExpect(jsonPath("$.fullPicture").value(DEFAULT_FULL_PICTURE.toString()))
            .andExpect(jsonPath("$.shareCount").value(DEFAULT_SHARE_COUNT.intValue()))
            .andExpect(jsonPath("$.reactionsCount").value(DEFAULT_REACTIONS_COUNT.intValue()))
            .andExpect(jsonPath("$.commentCount").value(DEFAULT_COMMENT_COUNT.intValue()))
            .andExpect(jsonPath("$.likeCount").value(DEFAULT_LIKE_COUNT.intValue()))
            .andExpect(jsonPath("$.loveCount").value(DEFAULT_LOVE_COUNT.intValue()))
            .andExpect(jsonPath("$.wowCount").value(DEFAULT_WOW_COUNT.intValue()))
            .andExpect(jsonPath("$.hahaCount").value(DEFAULT_HAHA_COUNT.intValue()))
            .andExpect(jsonPath("$.sadCount").value(DEFAULT_SAD_COUNT.intValue()))
            .andExpect(jsonPath("$.angryCount").value(DEFAULT_ANGRY_COUNT.intValue()))
            .andExpect(jsonPath("$.thankfulCount").value(DEFAULT_THANKFUL_COUNT.intValue()))
            .andExpect(jsonPath("$.createdDate").value(sameInstant(DEFAULT_CREATED_DATE)))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY.toString()))
            .andExpect(jsonPath("$.modifiedDate").value(sameInstant(DEFAULT_MODIFIED_DATE)))
            .andExpect(jsonPath("$.modifiedBy").value(DEFAULT_MODIFIED_BY.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingPost() throws Exception {
        // Get the post
        restPostMockMvc.perform(get("/api/posts/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updatePost() throws Exception {
        // Initialize the database
        postRepository.saveAndFlush(post);
        int databaseSizeBeforeUpdate = postRepository.findAll().size();

        // Update the post
        Post updatedPost = postRepository.findOne(post.getId());
        updatedPost
            .message(UPDATED_MESSAGE)
            .pageId(UPDATED_PAGE_ID)
            .pageName(UPDATED_PAGE_NAME)
            .category(UPDATED_CATEGORY)
            .categories(UPDATED_CATEGORIES)
            .link(UPDATED_LINK)
            .picture(UPDATED_PICTURE)
            .fullPicture(UPDATED_FULL_PICTURE)
            .shareCount(UPDATED_SHARE_COUNT)
            .reactionsCount(UPDATED_REACTIONS_COUNT)
            .commentCount(UPDATED_COMMENT_COUNT)
            .likeCount(UPDATED_LIKE_COUNT)
            .loveCount(UPDATED_LOVE_COUNT)
            .wowCount(UPDATED_WOW_COUNT)
            .hahaCount(UPDATED_HAHA_COUNT)
            .sadCount(UPDATED_SAD_COUNT)
            .angryCount(UPDATED_ANGRY_COUNT)
            .thankfulCount(UPDATED_THANKFUL_COUNT)
            .createdDate(UPDATED_CREATED_DATE)
            .createdBy(UPDATED_CREATED_BY)
            .modifiedDate(UPDATED_MODIFIED_DATE)
            .modifiedBy(UPDATED_MODIFIED_BY);
        PostDTO postDTO = postMapper.toDto(updatedPost);

        restPostMockMvc.perform(put("/api/posts")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(postDTO)))
            .andExpect(status().isOk());

        // Validate the Post in the database
        List<Post> postList = postRepository.findAll();
        assertThat(postList).hasSize(databaseSizeBeforeUpdate);
        Post testPost = postList.get(postList.size() - 1);
        assertThat(testPost.getMessage()).isEqualTo(UPDATED_MESSAGE);
        assertThat(testPost.getPageId()).isEqualTo(UPDATED_PAGE_ID);
        assertThat(testPost.getPageName()).isEqualTo(UPDATED_PAGE_NAME);
        assertThat(testPost.getCategory()).isEqualTo(UPDATED_CATEGORY);
        assertThat(testPost.getCategories()).isEqualTo(UPDATED_CATEGORIES);
        assertThat(testPost.getLink()).isEqualTo(UPDATED_LINK);
        assertThat(testPost.getPicture()).isEqualTo(UPDATED_PICTURE);
        assertThat(testPost.getFullPicture()).isEqualTo(UPDATED_FULL_PICTURE);
        assertThat(testPost.getShareCount()).isEqualTo(UPDATED_SHARE_COUNT);
        assertThat(testPost.getReactionsCount()).isEqualTo(UPDATED_REACTIONS_COUNT);
        assertThat(testPost.getCommentCount()).isEqualTo(UPDATED_COMMENT_COUNT);
        assertThat(testPost.getLikeCount()).isEqualTo(UPDATED_LIKE_COUNT);
        assertThat(testPost.getLoveCount()).isEqualTo(UPDATED_LOVE_COUNT);
        assertThat(testPost.getWowCount()).isEqualTo(UPDATED_WOW_COUNT);
        assertThat(testPost.getHahaCount()).isEqualTo(UPDATED_HAHA_COUNT);
        assertThat(testPost.getSadCount()).isEqualTo(UPDATED_SAD_COUNT);
        assertThat(testPost.getAngryCount()).isEqualTo(UPDATED_ANGRY_COUNT);
        assertThat(testPost.getThankfulCount()).isEqualTo(UPDATED_THANKFUL_COUNT);
        assertThat(testPost.getCreatedDate()).isEqualTo(UPDATED_CREATED_DATE);
        assertThat(testPost.getCreatedBy()).isEqualTo(UPDATED_CREATED_BY);
        assertThat(testPost.getModifiedDate()).isEqualTo(UPDATED_MODIFIED_DATE);
        assertThat(testPost.getModifiedBy()).isEqualTo(UPDATED_MODIFIED_BY);
    }

    @Test
    @Transactional
    public void updateNonExistingPost() throws Exception {
        int databaseSizeBeforeUpdate = postRepository.findAll().size();

        // Create the Post
        PostDTO postDTO = postMapper.toDto(post);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restPostMockMvc.perform(put("/api/posts")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(postDTO)))
            .andExpect(status().isCreated());

        // Validate the Post in the database
        List<Post> postList = postRepository.findAll();
        assertThat(postList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deletePost() throws Exception {
        // Initialize the database
        postRepository.saveAndFlush(post);
        int databaseSizeBeforeDelete = postRepository.findAll().size();

        // Get the post
        restPostMockMvc.perform(delete("/api/posts/{id}", post.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Post> postList = postRepository.findAll();
        assertThat(postList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Post.class);
        Post post1 = new Post();
        post1.setId(1L);
        Post post2 = new Post();
        post2.setId(post1.getId());
        assertThat(post1).isEqualTo(post2);
        post2.setId(2L);
        assertThat(post1).isNotEqualTo(post2);
        post1.setId(null);
        assertThat(post1).isNotEqualTo(post2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(PostDTO.class);
        PostDTO postDTO1 = new PostDTO();
        postDTO1.setId(1L);
        PostDTO postDTO2 = new PostDTO();
        assertThat(postDTO1).isNotEqualTo(postDTO2);
        postDTO2.setId(postDTO1.getId());
        assertThat(postDTO1).isEqualTo(postDTO2);
        postDTO2.setId(2L);
        assertThat(postDTO1).isNotEqualTo(postDTO2);
        postDTO1.setId(null);
        assertThat(postDTO1).isNotEqualTo(postDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(postMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(postMapper.fromId(null)).isNull();
    }
}
