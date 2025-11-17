# Matrix Class

## English Version

### Overview
A comprehensive Java class for matrix operations, providing a wide range of linear algebra functionalities including basic arithmetic operations, advanced matrix computations, and utility methods.

### Features

#### Basic Operations
- Multiple constructors for matrix creation
- Formatted matrix printing
- Matrix equality comparison

#### Arithmetic Operations
- Matrix addition
- Matrix subtraction
- Scalar multiplication
- Matrix multiplication (left and right)
- Matrix transposition

#### Advanced Operations
- Determinant calculation
- Inverse matrix computation
- Matrix trace calculation
- Matrix rank calculation
- Minor matrix calculation

### Constructors

#### 1. 1D Array Constructor (double type)
```java
Matrix(int rows, int cols, double[] nums)
```
- `rows`: Number of rows
- `cols`: Number of columns
- `nums`: 1D array in row-major order

#### 2. 1D Array Constructor (int type)
```java
Matrix(int rows, int cols, int[] nums)
```
- Automatically converts int to double

#### 3. Empty Matrix Constructor
```java
Matrix(int rows, int cols)
```
- Creates a zero matrix with specified dimensions

#### 4. 2D Array Constructor
```java
Matrix(double[][] matrix)
```
- Creates matrix directly from 2D array

### Methods

#### Basic Information
- `getrows()` - Get number of rows
- `getcols()` - Get number of columns
- `getMatrix()` - Get underlying 2D array
- `printMatrix()` - Format and print matrix

#### Basic Operations
- `addition(Matrix other)` - Matrix addition
- `subtraction(Matrix other)` - Matrix subtraction
- `multiplication(int k)` - Scalar multiplication
- `leftMultiplication(Matrix rightMatrix)` - Left multiplication
- `rightMultiplication(Matrix leftMatrix)` - Right multiplication
- `transpose()` - Matrix transposition

#### Advanced Operations
- `determinant()` - Calculate determinant (square matrices only)
- `inverse()` - Calculate inverse matrix
- `trace()` - Calculate matrix trace (square matrices only)
- `rank()` - Calculate matrix rank
- `getMinorMatrix(int row, int col)` - Get minor matrix
- `equals(Matrix other)` - Matrix equality comparison

### Example Usage

```java
// Create matrix
double[] data = {1, 2, 3, 4, 5, 6};
Matrix mat = new Matrix(2, 3, data);

// Compare matrices
mat.equals(new Matrix(mat.getMatrix()));

// Print matrix
mat.printMatrix();

// Basic operations
Matrix A = new Matrix(3, 3, new double[]{1, 0, 1, 0, 1, 0, 1, 0, 1});
Matrix B = new Matrix(3, 3, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
A.printMatrix();
B.printMatrix();
A.addition(B).printMatrix();
A.subtraction(B).printMatrix();
A.multiplication(2).printMatrix();
A.leftMultiplication(B).printMatrix();
A.rightMultiplication(B).printMatrix();

// Advanced operations
B.transpose().printMatrix();
A.addition(B).determinant();
B.getMinorMatrix(0, 0).printMatrix();
A.addition(B).inverse().printMatrix();
A.addition(B).inverse().leftMultiplication(A.addition(B)).printMatrix();
A.trace();
B.rank();
```

### Exception Handling
The class includes comprehensive exception handling:
- Illegal matrix dimension checks
- Operation dimension validation
- Singular matrix detection

### Notes
1. Matrix printing automatically adjusts format based on value precision
2. Decimal places beyond 5 are truncated to 5 digits
3. All operations return new Matrix objects without modifying the original
4. Supports formatted display of negative numbers

### Informations
- Author: Muimi272
- GitHub Repository: https://github.com/Muimi272/Matrix

---

## 中文版本

### 概述
一个功能全面的Java矩阵运算类，提供广泛的线性代数功能，包括基础算术运算、高级矩阵计算和实用方法。

### 功能特性

#### 基础功能
- 多种矩阵构造方法
- 格式化矩阵打印
- 矩阵相等性比较

#### 算术运算
- 矩阵加法
- 矩阵减法
- 标量乘法
- 矩阵乘法（左乘和右乘）
- 矩阵转置

#### 高级运算
- 行列式计算
- 逆矩阵计算
- 矩阵迹计算
- 矩阵秩计算
- 余子式计算

### 构造方法

#### 1. 一维数组构造（double类型）
```java
Matrix(int rows, int cols, double[] nums)
```
- `rows`: 矩阵行数
- `cols`: 矩阵列数
- `nums`: 按行优先顺序的一维数组

#### 2. 一维数组构造（int类型）
```java
Matrix(int rows, int cols, int[] nums)
```
- 自动将int转换为double类型

#### 3. 空矩阵构造
```java
Matrix(int rows, int cols)
```
- 创建指定行列的零矩阵

#### 4. 二维数组构造
```java
Matrix(double[][] matrix)
```
- 直接使用二维数组创建矩阵

### 方法说明

#### 基本信息获取
- `getrows()` - 获取行数
- `getcols()` - 获取列数
- `getMatrix()` - 获取底层二维数组
- `printMatrix()` - 格式化打印矩阵

#### 基础运算
- `addition(Matrix other)` - 矩阵加法
- `subtraction(Matrix other)` - 矩阵减法
- `multiplication(int k)` - 标量乘法
- `leftMultiplication(Matrix rightMatrix)` - 左乘
- `rightMultiplication(Matrix leftMatrix)` - 右乘
- `transpose()` - 矩阵转置

#### 高级运算
- `determinant()` - 计算行列式（仅方阵）
- `inverse()` - 计算逆矩阵
- `trace()` - 计算矩阵迹（仅方阵）
- `rank()` - 计算矩阵秩
- `getMinorMatrix(int row, int col)` - 获取余子式
- `equals(Matrix other)` - 矩阵相等性比较

### 使用示例

```java
// 创建矩阵
double[] data = {1, 2, 3, 4, 5, 6};
Matrix mat = new Matrix(2, 3, data);

// 比较矩阵
mat.equals(neww Matrix(mat.getMatrix());

// 打印矩阵
mat.printMatrix();

// 基础运算
Matrix A = new Matrix(3, 3, new double[]{1, 0, 1, 0, 1, 0, 1, 0, 1});
Matrix B = new Matrix(3, 3, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
A.printMatrix();
B.printMatrix();
A.addition(B).printMatrix();
A.subtraction(B).printMatrix();
A.multiplication(2).printMatrix();
A.leftMultiplication(B).printMatrix();
A.rightMultiplication(B).printMatrix();

// 高级运算
B.transpose().printMatrix();
A.addition(B).determinant();
B.getMinorMatrix(0, 0).printMatrix();
A.addition(B).inverse().printMatrix();
A.addition(B).inverse().leftMultiplication(A.addition(B)).printMatrix();
A.trace();
B.rank();
```

### 异常处理
类中包含完善的异常处理：
- 非法矩阵维度检查
- 运算维度匹配验证
- 奇异矩阵检测等

### 注意事项
1. 矩阵打印会自动根据数值精度调整格式
2. 小数位数超过5位时只显示前5位
3. 所有运算都返回新的Matrix对象，不修改原矩阵
4. 支持负数的格式化显示

### 信息
- 作者: Muimi272
- GitHub 仓库: https://github.com/Muimi272/Matrix
---
