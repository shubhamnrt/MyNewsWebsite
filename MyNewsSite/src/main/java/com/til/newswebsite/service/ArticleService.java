package com.til.newswebsite.service;

import com.til.newswebsite.dto.*;

<<<<<<< HEAD
=======
import java.util.ArrayList;
>>>>>>> 09abe1a959f68e11dde68ec1830c3416eafa8dde
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Comparator;

<<<<<<< HEAD
public interface ArticleService {
    public ArticleCreateResponseDto createArticle(ArticleDto articleDto);
    public List<ArticleListResponseDto> getArticles();
    public ArticleResponseDto getArticleById(int id);
    public ArticleResponseDto getArticleByTitle(String title);
    public String deleteArticle(int id);
    public String updateArticleDescription(ArticleDescriptionUpdateDto articleDescriptionUpdateDto);
    public String updateArticleTitle(ArticleTitleUpdateDto articleTitleUpdateDto);
    public String updateArticleContent(ArticleContentUpdateDto articleContentUpdateDto);
    public String updateArticleImageURl(ArticleImageUrlUpdateDto articleImageUrlUpdateDto);
=======
@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public ArticleCreateResponseDto createArticle(ArticleDto articleDto) {

        Article article = new Article();
        ArticleCreateResponseDto articleCreateResponseDto = new ArticleCreateResponseDto();

        article.setCategory(categoryRepository.getById(articleDto.getCategoryId()));
        article.setAuthor(authorRepository.getById(articleDto.getAuthorId()));
        article.setContent(articleDto.getContent());
        article.setDescription(articleDto.getDescription());
        article.setImageUrl(articleDto.getImageUrl());
        article.setTitle(articleDto.getTitle());
        // categoryRepository.getById(articleDto.getCategoryId()).addArticle(article);

        return new ArticleCreateResponseDto("success",articleRepository.save(article).getArticleId());
    }

    public List<ArticleListResponseDto> getArticles(String limit){
        List<ArticleListResponseDto> articleListResponseDtoList = new ArrayList<>();

        articleRepository.findAll().forEach(article -> {

            articleListResponseDtoList.add(new ArticleListResponseDto(
                    article.getArticleId(),article.getTitle(),article.getDescription(),
                    article.getCategory().getCategoryName(),article.getAuthor().getFullName(),
                    article.getImageUrl(),article.getCreatedAt()));
        });

        articleListResponseDtoList.sort(Comparator.comparing(ArticleListResponseDto::getCreatedAt).reversed());
        
        int limitInt = Integer.parseInt(limit);
        
        if(limitInt==-1){
            return articleListResponseDtoList;
        }
        else{
            Stream<ArticleListResponseDto> stream = articleListResponseDtoList.stream();
            return stream.limit(limitInt).collect(Collectors.toList());
        }
        
    }

    public ArticleResponseDto getArticleById(int id){

        Article article = articleRepository.findById(id).orElse(null);

        return new ArticleResponseDto(
                article.getArticleId(),article.getTitle(),article.getDescription(),article.getContent(),
                article.getCategory().getCategoryName(),article.getAuthor().getFullName(),
                article.getImageUrl(),article.getCreatedAt());

    }

    public ArticleResponseDto getArticleByTitle(String title){

        Article article = articleRepository.findByTitle(title);

        return new ArticleResponseDto(
                article.getArticleId(),article.getTitle(),article.getDescription(),article.getContent(),
                article.getCategory().getCategoryName(),article.getAuthor().getFullName(),
                article.getImageUrl(),article.getCreatedAt());

    }

    public String deleteArticle(int id) {
        articleRepository.deleteById(id);
        return "Article removed !! " + id;
    }

    public String updateArticleDescription(DescriptionDto descriptionDto){
        Article article = articleRepository.getById(descriptionDto.getArticleId());
        article.setDescription(descriptionDto.getDescription());
        articleRepository.save(article);
        return "Updated Description!";
    }

    public String updateArticleTitle(TitleDto titleDto){
        Article article = articleRepository.getById(titleDto.getArticleId());
        article.setTitle(titleDto.getTitle());
        articleRepository.save(article);
        return "Updated Title";
    }

    public String updateArticleContent(ContentDto contentDto){
        Article article = articleRepository.getById(contentDto.getArticleId());
        article.setContent(contentDto.getContent());
        articleRepository.save(article);
        return "Updated Content";
    }

    public String updateArticleImageURl(ImageUrlDto imageUrlDto){
        Article article = articleRepository.getById(imageUrlDto.getArticleId());
        article.setImageUrl(imageUrlDto.getImageUrl());
        articleRepository.save(article);
        return "Updated ImageUrl";
    }

>>>>>>> 09abe1a959f68e11dde68ec1830c3416eafa8dde
}
