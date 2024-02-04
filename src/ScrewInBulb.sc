;;; Sierra Script 1.0 - (do not remove this comment)
(script# 530)
(include sci.sh)
(use Main)
(use LBRoom)
(use Scaler)
(use Osc)
(use PolyPath)
(use CueObj)
(use n958)
(use Sound)
(use Cycle)
(use View)
(use Obj)

(public
	rm530 0
)

(instance rm530 of LBRoom
	(properties
		picture 530
		north 600
		south 510
		vanishingX 0
	)
	
	(method (init)
		(proc958_0 128 530 541 542 831)
		(proc958_0 132 540 541 542 543 558)
		(gEgo init: normalize: 831 setScale: Scaler 105 0 190 0)
		(self setRegions: 90)
		(switch gGNumber
			(north
				(proc0_3 31)
				(gEgo x: 236 y: 136)
				(self setScript: sUpStairs)
			)
			(south
				(self setScript: sEnterSouth)
			)
			(else 
				(gEgo posn: 65 180)
				(gGame handsOn:)
			)
		)
		(super init:)
		(if (and (proc0_2 31) (proc0_2 33))
			(gLb2WH addToFront: wallInside pit rearStairs)
		)
		(if (proc0_2 31)
			(if (proc0_2 32)
				(darkPassage init:)
				(lightBulb init: setCel: 1)
			else
				(lightBulb init:)
			)
		else
			(doorSeam init: setOnMeCheck: 1 32)
			(secretDoor addToPic:)
		)
		(windows init: setOnMeCheck: 1 2)
		(stairwellWall init: setOnMeCheck: 1 256)
		(hallWall init: setOnMeCheck: 1 512)
		(floor init: setOnMeCheck: 1 1024)
		(stairs init: setOnMeCheck: 1 4)
		(pit init: setOnMeCheck: 1 8)
		(wallInside init: setOnMeCheck: 1 128)
		(rearStairs init: setOnMeCheck: 1 4096)
		(socket init: setOnMeCheck: 1 16)
	)
	
	(method (doit)
		(super doit:)
		(cond 
			(script)
			((proc0_1 gEgo 16384) (self setScript: sExitSouth))
			((proc0_1 gEgo 8192) (self setScript: sExitSouthWalk))
			((and (proc0_1 gEgo 8) (proc0_2 32)) (self setScript: sFallStairs))
		)
	)
	
	(method (dispose)
		(if (proc0_2 33)
			(gLb2WH delete: wallInside pit rearStairs)
		)
		(super dispose:)
	)
)

(instance lightBulb of View
	(properties
		x 162
		y 109
		noun 14
		view 541
		loop 4
		priority 15
		signal $4011
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (not cel)
					(gLb2Messager say: noun theVerb 2)
				else
					(gLb2Messager say: noun theVerb 1)
				)
			)
			(39
				(if (not cel)
					(global2 setScript: sReadCarbonPaper)
				else
					(gLb2Messager say: noun theVerb 4)
				)
			)
			(4
				(cond 
					(
					(or (gEgo has: 23) (not (proc0_2 64)) (not cel)) (gLb2Messager say: noun theVerb 5))
					((not cel) (gLb2Messager say: noun theVerb 2))
					(else (gLb2Messager say: noun theVerb 1))
				)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance darkPassage of View
	(properties
		x 111
		y 88
		noun 11
		view 530
		loop 1
		priority 5
		signal $4011
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (== (lightBulb cel?) 0)
					(gLb2Messager say: 11 1 2)
				else
					(gLb2Messager say: 11 1)
				)
			)
			(8
				(if (== (lightBulb cel?) 0)
					(gLb2Messager say: 11 8 2)
				else
					(gLb2Messager say: 11 8)
				)
			)
			(33
				(global2 setScript: sReplaceLightBulb)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance secretDoor of View
	(properties
		x 113
		y 89
		noun 10
		view 530
		priority 13
		signal $4011
	)
)

(instance windows of Feature
	(properties
		y 1
		noun 1
		sightAngle 40
	)
)

(instance stairs of Feature
	(properties
		y 1
		noun 6
		sightAngle 40
	)
	
	(method (initialize)
	)
)

(instance rearStairs of Feature
	(properties
		y 1
		noun 6
		sightAngle 40
	)
	
	(method (initialize)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(3
				(if (and (proc0_2 33) (proc0_2 31))
					(global2 setScript: sExitNorth)
				)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance pit of Feature
	(properties
		y 1
		noun 7
		sightAngle 40
	)
	
	(method (initialize)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (== (lightBulb cel?) 0)
					(gLb2Messager say: 7 1 2)
				else
					(gLb2Messager say: 7 1)
				)
			)
			(3
				(if (and (proc0_2 33) (proc0_2 31))
					(global2 setScript: sExitNorth)
				)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance socket of Feature
	(properties
		y 1
		noun 9
		sightAngle 40
	)
)

(instance doorSeam of Feature
	(properties
		y 1
		noun 5
		sightAngle 40
	)
)

(instance wallInside of Feature
	(properties
		y 1
		noun 8
		sightAngle 40
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(3
				(if (and (proc0_2 33) (proc0_2 31))
					(global2 setScript: sExitNorth)
				)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance stairwellWall of Feature
	(properties
		y 1
		noun 2
		sightAngle 40
	)
)

(instance hallWall of Feature
	(properties
		y 1
		noun 3
		sightAngle 40
	)
)

(instance floor of Feature
	(properties
		y 1
		noun 15
		sightAngle 40
	)
)

(instance sReplaceLightBulb of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= register (Sound new:))
				(gEgo setMotion: PolyPath 155 161 self)
			)
			(1 (gEgo setHeading: 0 self))
			(2
				(gEgo
					view: 541
					setLoop: 1
					setCel: 0
					posn: 153 158
					setScale: Scaler 100 100 190 0
					setCycle: CT 3 1 self
				)
			)
			(3
				(gEgo setCycle: ScrewInBulb 6 register self)
			)
			(4
				(gGame points: 1 167)
				(sFX number: 558 play:)
				(lightBulb setCel: 0)
				(darkPassage hide:)
				(= cycles 1)
			)
			(5 (gEgo setCycle: End self))
			(6
				((ScriptID 21 1) doit: 792)
				(gEgo
					normalize: 831
					loop: 6
					cel: 5
					setScale: Scaler 105 0 190 0
					posn: 152 158
				)
				(proc0_4 32)
				(proc0_3 33)
				(gEgo put: 23)
				(gLb2WH addToFront: wallInside pit rearStairs)
				(lightBulb stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sReadCarbonPaper of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 155 161 self)
			)
			(1 (gEgo setHeading: 0 self))
			(2
				(gEgo
					view: 541
					setLoop: 2
					setCel: 0
					posn: 153 158
					setScale: Scaler 100 100 190 0
					setCycle: End self
				)
			)
			(3
				(gLb2Messager say: 14 39 3)
				(gGame points: 1 170)
				(= cycles 1)
			)
			(4 (gEgo setCycle: Beg self))
			(5
				(gEgo
					setLoop: 6
					setCel: 5
					posn: 152 158
					normalize: 831
					setScale: Scaler 105 0 190 0
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFallStairs of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 167 150 self)
			)
			(1
				(gEgo
					view: 542
					setLoop: 0
					setCel: 0
					posn: 169 148
					setScale: Scaler 100 100 190 0
					setCycle: End self
				)
			)
			(2
				(cutPassageBottomMask init:)
				(cutFloorMask init:)
				(gEgo
					setPri: 6
					yStep: 16
					setMotion: MoveTo (gEgo x?) 183 self
				)
				(sFX number: 542 flags: 1 setLoop: 1 play:)
			)
			(3 (gEgo hide:) (= ticks 120))
			(4
				(sFX number: 543 play:)
				(= ticks 180)
			)
			(5
				(= global145 14)
				(global2 newRoom: 99)
				(self dispose:)
			)
		)
	)
)

(instance cutPassageBottomMask of View
	(properties
		x 111
		y 149
		view 530
		loop 2
		priority 14
		signal $4011
	)
)

(instance cutFloorMask of View
	(properties
		x 111
		y 178
		view 530
		loop 3
		priority 15
		signal $4011
	)
)

(instance sUpStairs of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGameMusic2 number: 540 loop: -1 flags: 1 play:)
				(= cycles 3)
			)
			(1
				(gEgo setMotion: MoveTo 103 138 self)
			)
			(2
				(gEgo setMotion: MoveTo 109 161 self)
			)
			(3
				(gGameMusic2 fade:)
				(gEgo setMotion: MoveTo 147 162 self)
			)
			(4
				(WrapMusic pause: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitNorth of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 136 158 self)
			)
			(1
				(WrapMusic pause: 1)
				(gGameMusic2 number: 541 loop: -1 flags: 1 play:)
				(gEgo
					view: 541
					setScale: Scaler 100 100 190 0
					setLoop: 0
					setCel: 0
					posn: 127 165
					setPri: 12
					setCycle: End self
				)
			)
			(2
				(gEgo
					normalize: 831
					setScale: Scaler 105 0 190 0
					posn: 99 161
					setPri: -1
					setMotion: MoveTo 107 140 self
				)
			)
			(3
				(gEgo setMotion: PolyPath 221 147 self)
			)
			(4
				(gEgo edgeHit: 1)
				(global2 newRoom: (global2 north?))
			)
		)
	)
)

(instance sExitSouth of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(global2 newRoom: (global2 south?))
			)
		)
	)
)

(instance sExitSouthWalk of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (> (gEgo x?) 150)
					(gEgo setMotion: MoveTo 229 148 self)
				else
					(gEgo setMotion: MoveTo 88 147 self)
				)
			)
			(1
				(global2 newRoom: (global2 south?))
			)
		)
	)
)

(instance sEnterSouth of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (> (Random 0 1) 0)
					(gEgo
						posn: 84 152
						setHeading: 270
						setMotion: MoveTo 58 161 self
					)
				else
					(gEgo
						posn: 238 155
						setHeading: 90
						setMotion: MoveTo 262 157 self
					)
				)
			)
			(1
				(if (and (proc0_2 31) (not (proc0_2 32)))
					(if (proc0_2 33)
						(gGame handsOn:)
						(self dispose:)
					else
						(gGame handsOn:)
						(= ticks 120)
					)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(2
				(proc0_3 32)
				(sFX number: 558 play:)
				(lightBulb setCel: 1)
				(darkPassage init:)
				(= ticks 120)
			)
			(3
				(gLb2Messager say: 12 0 1)
				(self dispose:)
			)
		)
	)
)

(class ScrewInBulb of Osc
	(properties
		client 0
		caller 0
		cycleDir 1
		cycleCnt 0
		completed 0
		howManyCycles -1
		soundOsc 1
	)
	
	(method (init param1 theHowManyCycles theSoundOsc theCaller)
		(if (>= argc 2)
			(= howManyCycles theHowManyCycles)
			(if (>= argc 3)
				(= soundOsc theSoundOsc)
				(if (>= argc 4) (= caller theCaller))
			)
		)
		(super init: param1 theHowManyCycles theCaller)
	)
	
	(method (doit &tmp screwInBulbNextCel)
		(if
			(or
				(> (= screwInBulbNextCel (self nextCel:)) 4)
				(< screwInBulbNextCel 3)
			)
			(= cycleDir (- cycleDir))
			(self cycleDone:)
		else
			(client cel: screwInBulbNextCel)
		)
	)
	
	(method (cycleDone)
		(soundOsc number: 553 play:)
		(super cycleDone:)
	)
)

(instance sFX of Sound
	(properties
		flags $0001
	)
)
