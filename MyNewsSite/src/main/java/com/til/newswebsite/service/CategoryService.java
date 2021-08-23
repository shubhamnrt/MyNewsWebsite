package com.til.newswebsite.service;

import com.til.newswebsite.dto.ArticleListResponseDto;
import com.til.newswebsite.dto.CategoryDto;
import com.til.newswebsite.dto.CategoryResponseDto;

<<<<<<< HEAD
=======
import java.util.ArrayList;
>>>>>>> 09abe1a959f68e11dde68ec1830c3416eafa8dde
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Comparator;

<<<<<<< HEAD
public interface CategoryService {

    public CategoryResponseDto addCategory(CategoryDto categoryDto);
    public List<CategoryResponseDto> getAllCategory();
    public CategoryResponseDto getCategoryById(Integer id);
    public List<ArticleListResponseDto> getAllArticlesFromCategory(Integer categoryId);
=======
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ArticleRepository articleRepository;


    public CategoryResponseDto addCategory(CategoryDto categoryDto){
        Category category = new Category();
        category.setCategoryName(categoryDto.getCategoryName());
        category.setDescription(categoryDto.getDescription());
        category = categoryRepository.save(category);
        return new CategoryResponseDto(category.getId(),category.getCategoryName(),category.getDescription());
    }


    public List<CategoryResponseDto> getAllCategory(){
        List<CategoryResponseDto> categoryResponseDtoList = new ArrayList<>();
        categoryRepository.findAll().forEach(category -> {
            categoryResponseDtoList.add(new CategoryResponseDto(category.getId(),
                    category.getCategoryName(),category.getDescription()));
        });

        return categoryResponseDtoList;
    }


    public CategoryResponseDto getCategoryById(Integer id){
        Category category = categoryRepository.findById(id).orElse(null);
        return new CategoryResponseDto(category.getId(),category.getCategoryName(),category.getDescription());
    }


    public List<ArticleListResponseDto> getAllArticlesFromCategory(String categoryName, String limit){
        List<ArticleListResponseDto> articleListResponseDtoList = new ArrayList<>();

        articleRepository.findAllByCategory(categoryRepository.findByCategoryName(categoryName)).forEach(article -> {

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
>>>>>>> 09abe1a959f68e11dde68ec1830c3416eafa8dde
}
