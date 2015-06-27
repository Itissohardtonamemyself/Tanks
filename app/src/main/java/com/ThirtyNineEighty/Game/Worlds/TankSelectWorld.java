package com.ThirtyNineEighty.Game.Worlds;

import com.ThirtyNineEighty.Resources.Entities.Characteristic;
import com.ThirtyNineEighty.Game.Objects.Land;
import com.ThirtyNineEighty.Game.Objects.Tank;
import com.ThirtyNineEighty.Helpers.Angle;
import com.ThirtyNineEighty.Helpers.Vector3;
import com.ThirtyNineEighty.Renderable.Camera;

public class TankSelectWorld
  extends BaseWorld
{
  private float angle = 35;
  private float length = 8;

  @Override
  public void initialize(Object args)
  {
    add(new Land());
    add(player = new Tank(Characteristic.Tank));

    super.initialize(args);
  }

  @Override
  public void uninitialize()
  {
    super.uninitialize();
  }

  public void addLength(float value)
  {
    length += value;

    if (length < 4)
      length = 4;

    if (length > 10)
      length = 10;
  }

  public void addAngle(float value)
  {
    angle = Angle.correct(angle + value);
  }

  public void setPlayer(String tankName)
  {
    remove(player);
    add(player = new Tank(tankName));
  }

  @Override
  public void setCamera(Camera camera)
  {
    camera.target.setFrom(player.getPosition());

    float height = length / 2;
    float x = length * (float)Math.cos(Math.toRadians(angle));
    float y = length * (float)Math.sin(Math.toRadians(angle));

    camera.eye.setFrom(x, y, height);
  }

  @Override
  public void setLight(Vector3 lightPosition)
  {
    float height = 10 + length / 2;
    float x = length * (float)Math.cos(Math.toRadians(angle));
    float y = length * (float)Math.sin(Math.toRadians(angle));

    lightPosition.setFrom(x, y, height);
  }
}
