interface StaticMatrices
{
  // red band Matrix
  static final float RED_BAND_MATRIX[][] = { { 1.0f, 0.0f, 0.0f },
      { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f } };
  // green band Matrix
  static final float GREEN_BAND_MATRIX[][] = { { 0.0f, 0.0f, 0.0f },
      { 0.0f, 1.0f, 0.0f }, { 0.0f, 0.0f, 0.0f } };
  // blue band Matrix
  static final float BLUE_BAND_MATRIX[][] = { { 0.0f, 0.0f, 0.0f },
      { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 1.0f } };
  // Matrix that inverts all the bands
  // the nagative of the image.
  static final float INVERSE_BAND_MATRIX[][] = { { -1.0f, 0.0f, 0.0f },
      { 0.0f, -1.0f, 0.0f }, { 0.0f, 0.0f, -1.0f } };
  // yellow
  static final float AVERAGE_BAND_MATRIX[][] = { { 1.0f, 0.0f, 0.0f },
      { 0.0f, 1.0f, 0.0f }, { 0.0f, 0.0f, 0.0f } };
  //matrix for sharpening
  static final float  SHARPEN_MATRIX[]={ 0.0f, -1.0f, 0.0f,-1.0f, 5.0f, -1.0f,0.0f, -1.0f, 0.0f};
 //matrix for blurring
  static final float  BLUR_MATRIX[]={ (1/8)f,(1/8)f, (1/8)f,(1/8)f,(1/8)f,(1/8)f,(1/8)f, (1/9)f,(1/9)f};
 //matrix for edge detect
  static final float  EDGE_MATRIX[]={ 0.0f, -1.0f, 0.0f,-1.0f, -20.f, -1.0f,0.0f, -1.0f, 0.0f};


}