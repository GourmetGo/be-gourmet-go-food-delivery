package com.gourmetGo.dto.request;

import com.gourmetGo.model.Product;
import com.gourmetGo.model.user.Courier;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class OrderRequestDto {
    @Nullable
    private Courier courier;
    private List<Product> products = new ArrayList<>();


}
