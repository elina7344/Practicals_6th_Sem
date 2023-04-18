#Link:   https://github.com/sdsubhajitdas/Rocket_Lander_Gym

import gym
import gym.spaces
import rocket_lander_gym

env = gym.make('RocketLander-v0')
env.reset()

PRINT_DEBUG_MSG = True


while True:
    env.render()
    action = env.action_space.sample()
    observation,reward,done,info =env.step(action)

    if PRINT_DEBUG_MSG:
        print("Action Taken  ",action)
        print("Observation   ",observation)
        print("Reward Gained ",reward)
        print("Info          ",info,end='\n\n')

    if done:
        print("Simulation done.")
        break
env.close()




'''
from setuptools import setup

setup(name='rocket_lander_gym',
      version='0.1',
      url='https://github.com/Jeetu95/Rocket_Lander_Gym',
      author='Subhajit Das',
      author_email='jeetudas95@gmail.com',
      description='Rocket Lander',
      license='MIT',
      packages=['rocket_lander_gym','rocket_lander_gym.envs'],
      install_requires=['gym','box2d-py','numpy']
      )
'''
