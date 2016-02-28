package nc.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFusionReactor extends ModelBase
{
  //fields
    ModelRenderer Corner1;
    ModelRenderer Corner2;
    ModelRenderer Corner3;
    ModelRenderer Corner4;
    ModelRenderer Corner5;
    ModelRenderer Corner6;
    ModelRenderer Corner7;
    ModelRenderer Corner8;
    ModelRenderer Corner9;
    ModelRenderer Corner10;
    ModelRenderer Corner11;
    ModelRenderer Corner12;
    ModelRenderer Corner13;
    ModelRenderer Corner14;
    ModelRenderer Corner15;
    ModelRenderer Corner16;
    ModelRenderer Corner17;
    ModelRenderer Corner18;
    ModelRenderer Corner19;
    ModelRenderer Corner20;
    ModelRenderer Corner21;
    ModelRenderer Corner22;
    ModelRenderer Corner23;
    ModelRenderer Corner24;
    ModelRenderer Corner25;
    ModelRenderer Corner26;
    ModelRenderer Corner27;
    ModelRenderer Corner28;
    ModelRenderer Bar1;
    ModelRenderer Bar2;
    ModelRenderer Bar3;
    ModelRenderer Bar4;
    ModelRenderer Bar5;
    ModelRenderer Bar6;
    ModelRenderer Bar7;
    ModelRenderer Bar8;
    ModelRenderer Base1;
    ModelRenderer Middle1;
    ModelRenderer Top1;
  
  public ModelFusionReactor()
  {
    textureWidth = 256;
    textureHeight = 128;
    
      Corner1 = new ModelRenderer(this, 0, 26);
      Corner1.addBox(0F, 0F, 0F, 16, 1, 16);
      Corner1.setRotationPoint(-24F, 22F, -24F);
      Corner1.setTextureSize(256, 128);
      Corner1.mirror = true;
      setRotation(Corner1, 0F, 0F, 0F);
      Corner2 = new ModelRenderer(this, 0, 26);
      Corner2.addBox(0F, 0F, 0F, 16, 1, 16);
      Corner2.setRotationPoint(8F, 22F, -24F);
      Corner2.setTextureSize(256, 128);
      Corner2.mirror = true;
      setRotation(Corner2, 0F, 0F, 0F);
      Corner3 = new ModelRenderer(this, 0, 26);
      Corner3.addBox(0F, 0F, 0F, 16, 1, 16);
      Corner3.setRotationPoint(8F, 22F, 8F);
      Corner3.setTextureSize(256, 128);
      Corner3.mirror = true;
      setRotation(Corner3, 0F, 0F, 0F);
      Corner4 = new ModelRenderer(this, 0, 26);
      Corner4.addBox(0F, 0F, 0F, 16, 1, 16);
      Corner4.setRotationPoint(-24F, 22F, 8F);
      Corner4.setTextureSize(256, 128);
      Corner4.mirror = true;
      setRotation(Corner4, 0F, 0F, 0F);
      Corner5 = new ModelRenderer(this, 64, 0);
      Corner5.addBox(0F, 0F, 0F, 14, 3, 14);
      Corner5.setRotationPoint(-22F, 19F, -22F);
      Corner5.setTextureSize(256, 128);
      Corner5.mirror = true;
      setRotation(Corner5, 0F, 0F, 0F);
      Corner6 = new ModelRenderer(this, 64, 0);
      Corner6.addBox(0F, 0F, 0F, 14, 3, 14);
      Corner6.setRotationPoint(8F, 19F, -22F);
      Corner6.setTextureSize(256, 128);
      Corner6.mirror = true;
      setRotation(Corner6, 0F, 0F, 0F);
      Corner7 = new ModelRenderer(this, 64, 0);
      Corner7.addBox(0F, 0F, 0F, 14, 3, 14);
      Corner7.setRotationPoint(8F, 19F, 8F);
      Corner7.setTextureSize(256, 128);
      Corner7.mirror = true;
      setRotation(Corner7, 0F, 0F, 0F);
      Corner8 = new ModelRenderer(this, 64, 0);
      Corner8.addBox(0F, 0F, 0F, 14, 3, 14);
      Corner8.setRotationPoint(-22F, 19F, 8F);
      Corner8.setTextureSize(256, 128);
      Corner8.mirror = true;
      setRotation(Corner8, 0F, 0F, 0F);
      Corner9 = new ModelRenderer(this, 120, 0);
      Corner9.addBox(0F, 0F, 0F, 12, 5, 12);
      Corner9.setRotationPoint(-20F, 14F, -20F);
      Corner9.setTextureSize(256, 128);
      Corner9.mirror = true;
      setRotation(Corner9, 0F, 0F, 0F);
      Corner10 = new ModelRenderer(this, 120, 0);
      Corner10.addBox(0F, 0F, 0F, 12, 5, 12);
      Corner10.setRotationPoint(8F, 14F, -20F);
      Corner10.setTextureSize(256, 128);
      Corner10.mirror = true;
      setRotation(Corner10, 0F, 0F, 0F);
      Corner11 = new ModelRenderer(this, 120, 0);
      Corner11.addBox(0F, 0F, 0F, 12, 5, 12);
      Corner11.setRotationPoint(8F, 14F, 8F);
      Corner11.setTextureSize(256, 128);
      Corner11.mirror = true;
      setRotation(Corner11, 0F, 0F, 0F);
      Corner12 = new ModelRenderer(this, 120, 0);
      Corner12.addBox(0F, 0F, 0F, 12, 5, 12);
      Corner12.setRotationPoint(-20F, 14F, 8F);
      Corner12.setTextureSize(256, 128);
      Corner12.mirror = true;
      setRotation(Corner12, 0F, 0F, 0F);
      Corner13 = new ModelRenderer(this, 168, 0);
      Corner13.addBox(0F, 0F, 0F, 10, 12, 10);
      Corner13.setRotationPoint(-18F, 2F, -18F);
      Corner13.setTextureSize(256, 128);
      Corner13.mirror = true;
      setRotation(Corner13, 0F, 0F, 0F);
      Corner14 = new ModelRenderer(this, 168, 0);
      Corner14.addBox(0F, 0F, 0F, 10, 12, 10);
      Corner14.setRotationPoint(8F, 2F, -18F);
      Corner14.setTextureSize(256, 128);
      Corner14.mirror = true;
      setRotation(Corner14, 0F, 0F, 0F);
      Corner15 = new ModelRenderer(this, 168, 0);
      Corner15.addBox(0F, 0F, 0F, 10, 12, 10);
      Corner15.setRotationPoint(8F, 2F, 8F);
      Corner15.setTextureSize(256, 128);
      Corner15.mirror = true;
      setRotation(Corner15, 0F, 0F, 0F);
      Corner16 = new ModelRenderer(this, 168, 0);
      Corner16.addBox(0F, 0F, 0F, 10, 12, 10);
      Corner16.setRotationPoint(-18F, 2F, 8F);
      Corner16.setTextureSize(256, 128);
      Corner16.mirror = true;
      setRotation(Corner16, 0F, 0F, 0F);
      Corner17 = new ModelRenderer(this, 120, 0);
      Corner17.addBox(0F, 0F, 0F, 12, 5, 12);
      Corner17.setRotationPoint(-20F, -3F, -20F);
      Corner17.setTextureSize(256, 128);
      Corner17.mirror = true;
      setRotation(Corner17, 0F, 0F, 0F);
      Corner18 = new ModelRenderer(this, 120, 0);
      Corner18.addBox(0F, 0F, 0F, 12, 5, 12);
      Corner18.setRotationPoint(8F, -3F, -20F);
      Corner18.setTextureSize(256, 128);
      Corner18.mirror = true;
      setRotation(Corner18, 0F, 0F, 0F);
      Corner19 = new ModelRenderer(this, 120, 0);
      Corner19.addBox(0F, 0F, 0F, 12, 5, 12);
      Corner19.setRotationPoint(8F, -3F, 8F);
      Corner19.setTextureSize(256, 128);
      Corner19.mirror = true;
      setRotation(Corner19, 0F, 0F, 0F);
      Corner20 = new ModelRenderer(this, 120, 0);
      Corner20.addBox(0F, 0F, 0F, 12, 5, 12);
      Corner20.setRotationPoint(-20F, -3F, 8F);
      Corner20.setTextureSize(256, 128);
      Corner20.mirror = true;
      setRotation(Corner20, 0F, 0F, 0F);
      Corner21 = new ModelRenderer(this, 64, 0);
      Corner21.addBox(0F, 0F, 0F, 14, 3, 14);
      Corner21.setRotationPoint(-22F, -6F, -22F);
      Corner21.setTextureSize(256, 128);
      Corner21.mirror = true;
      setRotation(Corner21, 0F, 0F, 0F);
      Corner22 = new ModelRenderer(this, 64, 0);
      Corner22.addBox(0F, 0F, 0F, 14, 3, 14);
      Corner22.setRotationPoint(8F, -6F, -22F);
      Corner22.setTextureSize(256, 128);
      Corner22.mirror = true;
      setRotation(Corner22, 0F, 0F, 0F);
      Corner23 = new ModelRenderer(this, 64, 0);
      Corner23.addBox(0F, 0F, 0F, 14, 3, 14);
      Corner23.setRotationPoint(8F, -6F, 8F);
      Corner23.setTextureSize(256, 128);
      Corner23.mirror = true;
      setRotation(Corner23, 0F, 0F, 0F);
      Corner24 = new ModelRenderer(this, 64, 0);
      Corner24.addBox(0F, 0F, 0F, 14, 3, 14);
      Corner24.setRotationPoint(-22F, -6F, 8F);
      Corner24.setTextureSize(256, 128);
      Corner24.mirror = true;
      setRotation(Corner24, 0F, 0F, 0F);
      Corner25 = new ModelRenderer(this, 0, 0);
      Corner25.addBox(0F, 0F, 0F, 16, 1, 16);
      Corner25.setRotationPoint(-24F, -7F, -24F);
      Corner25.setTextureSize(256, 128);
      Corner25.mirror = true;
      setRotation(Corner25, 0F, 0F, 0F);
      Corner26 = new ModelRenderer(this, 0, 0);
      Corner26.addBox(0F, 0F, 0F, 16, 1, 16);
      Corner26.setRotationPoint(8F, -7F, -24F);
      Corner26.setTextureSize(256, 128);
      Corner26.mirror = true;
      setRotation(Corner26, 0F, 0F, 0F);
      Corner27 = new ModelRenderer(this, 0, 0);
      Corner27.addBox(0F, 0F, 0F, 16, 1, 16);
      Corner27.setRotationPoint(8F, -7F, 8F);
      Corner27.setTextureSize(256, 128);
      Corner27.mirror = true;
      setRotation(Corner27, 0F, 0F, 0F);
      Corner28 = new ModelRenderer(this, 0, 0);
      Corner28.addBox(0F, 0F, 0F, 16, 1, 16);
      Corner28.setRotationPoint(-24F, -7F, 8F);
      Corner28.setTextureSize(256, 128);
      Corner28.mirror = true;
      setRotation(Corner28, 0F, 0F, 0F);
      Bar1 = new ModelRenderer(this, 76, 20);
      Bar1.addBox(0F, 0F, 0F, 16, 1, 2);
      Bar1.setRotationPoint(-8F, 22F, -24F);
      Bar1.setTextureSize(256, 128);
      Bar1.mirror = true;
      setRotation(Bar1, 0F, 0F, 0F);
      Bar2 = new ModelRenderer(this, 76, 20);
      Bar2.addBox(0F, 0F, 0F, 16, 1, 2);
      Bar2.setRotationPoint(22F, 22F, 8F);
      Bar2.setTextureSize(256, 128);
      Bar2.mirror = true;
      setRotation(Bar2, 0F, (float)(Math.PI)/2, 0F);
      Bar3 = new ModelRenderer(this, 76, 20);
      Bar3.addBox(0F, 0F, 0F, 16, 1, 2);
      Bar3.setRotationPoint(-8F, 22F, 22F);
      Bar3.setTextureSize(256, 128);
      Bar3.mirror = true;
      setRotation(Bar3, 0F, 0F, 0F);
      Bar4 = new ModelRenderer(this, 76, 20);
      Bar4.addBox(0F, 0F, 0F, 16, 1, 2);
      Bar4.setRotationPoint(-24F, 22F, 8F);
      Bar4.setTextureSize(256, 128);
      Bar4.mirror = true;
      setRotation(Bar4, 0F, (float)(Math.PI)/2, 0F);
      Bar5 = new ModelRenderer(this, 36, 20);
      Bar5.addBox(0F, 0F, 0F, 16, 1, 2);
      Bar5.setRotationPoint(-8F, -7F, -24F);
      Bar5.setTextureSize(256, 128);
      Bar5.mirror = true;
      setRotation(Bar5, 0F, 0F, 0F);
      Bar6 = new ModelRenderer(this, 36, 20);
      Bar6.addBox(0F, 0F, 0F, 16, 1, 2);
      Bar6.setRotationPoint(22F, -7F, 8F);
      Bar6.setTextureSize(256, 128);
      Bar6.mirror = true;
      setRotation(Bar6, 0F, (float)(Math.PI)/2, 0F);
      Bar7 = new ModelRenderer(this, 36, 20);
      Bar7.addBox(0F, 0F, 0F, 16, 1, 2);
      Bar7.setRotationPoint(-8F, -7F, 22F);
      Bar7.setTextureSize(256, 128);
      Bar7.mirror = true;
      setRotation(Bar7, 0F, 0F, 0F);
      Bar8 = new ModelRenderer(this, 36, 20);
      Bar8.addBox(0F, 0F, 0F, 16, 1, 2);
      Bar8.setRotationPoint(-24F, -7F, 8F);
      Bar8.setTextureSize(256, 128);
      Bar8.mirror = true;
      setRotation(Bar8, 0F, (float)(Math.PI)/2, 0F);
      Base1 = new ModelRenderer(this, 0, 45);
      Base1.addBox(0F, 0F, 0F, 48, 1, 48);
      Base1.setRotationPoint(-24F, 23F, -24F);
      Base1.setTextureSize(256, 128);
      Base1.mirror = true;
      setRotation(Base1, 0F, 0F, 0F);
      Middle1 = new ModelRenderer(this, 195, 24);
      Middle1.addBox(0F, 0F, 0F, 15, 30, 15);
      Middle1.setRotationPoint(0F, -7F, -10.7F);
      Middle1.setTextureSize(256, 128);
      Middle1.mirror = true;
      setRotation(Middle1, 0F, (float)(-Math.PI)/4, 0F);
      Top1 = new ModelRenderer(this, 0, 45);
      Top1.addBox(0F, 0F, 0F, 48, 1, 48);
      Top1.setRotationPoint(-24F, -8F, -24F);
      Top1.setTextureSize(256, 128);
      Top1.mirror = true;
      setRotation(Top1, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
	  super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Corner1.render(f5);
    Corner2.render(f5);
    Corner3.render(f5);
    Corner4.render(f5);
    Corner5.render(f5);
    Corner6.render(f5);
    Corner7.render(f5);
    Corner8.render(f5);
    Corner9.render(f5);
    Corner10.render(f5);
    Corner11.render(f5);
    Corner12.render(f5);
    Corner13.render(f5);
    Corner14.render(f5);
    Corner15.render(f5);
    Corner16.render(f5);
    Corner17.render(f5);
    Corner18.render(f5);
    Corner19.render(f5);
    Corner20.render(f5);
    Corner21.render(f5);
    Corner22.render(f5);
    Corner23.render(f5);
    Corner24.render(f5);
    Corner25.render(f5);
    Corner26.render(f5);
    Corner27.render(f5);
    Corner28.render(f5);
    Bar1.render(f5);
    Bar2.render(f5);
    Bar3.render(f5);
    Bar4.render(f5);
    Bar5.render(f5);
    Bar6.render(f5);
    Bar7.render(f5);
    Bar8.render(f5);
    Base1.render(f5);
    Middle1.render(f5);
    Top1.render(f5);
  }
  
  public void renderModel(float f)
  {
    Corner1.render(f);
    Corner2.render(f);
    Corner3.render(f);
    Corner4.render(f);
    Corner5.render(f);
    Corner6.render(f);
    Corner7.render(f);
    Corner8.render(f);
    Corner9.render(f);
    Corner10.render(f);
    Corner11.render(f);
    Corner12.render(f);
    Corner13.render(f);
    Corner14.render(f);
    Corner15.render(f);
    Corner16.render(f);
    Corner17.render(f);
    Corner18.render(f);
    Corner19.render(f);
    Corner20.render(f);
    Corner21.render(f);
    Corner22.render(f);
    Corner23.render(f);
    Corner24.render(f);
    Corner25.render(f);
    Corner26.render(f);
    Corner27.render(f);
    Corner28.render(f);
    Bar1.render(f);
    Bar2.render(f);
    Bar3.render(f);
    Bar4.render(f);
    Bar5.render(f);
    Bar6.render(f);
    Bar7.render(f);
    Bar8.render(f);
    Base1.render(f);
    Middle1.render(f);
    Top1.render(f);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}