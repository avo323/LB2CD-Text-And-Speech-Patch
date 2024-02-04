;;; Sierra Script 1.0 - (do not remove this comment)
(script# 660)
(include sci.sh)
(use Main)
(use LBRoom)
(use ExitFeature)
(use MuseumRgn)
(use PChase)
(use Scaler)
(use PolyPath)
(use CueObj)
(use MoveFwd)
(use n958)
(use Sound)
(use Cycle)
(use View)
(use Obj)

(public
	rm660 0
)

(local
	local0
)
(instance rm660 of LBRoom
	(properties
		picture 660
		south 460
	)
	
	(method (init)
		(proc958_0 132 662 661 660)
		(proc958_0 130 94 2660)
		(if (== global123 5)
			(self setRegions: 94)
			(global2 obstacles: (List new:))
			((ScriptID 2660 0) doit: (global2 obstacles?))
		else
			(self setRegions: 90)
			(MuseumRgn loadPolyList:)
		)
		(gEgo init: setScale: 125 normalize: 426)
		(super init:)
		(crank init: stopUpd:)
		(wall1 init: stopUpd:)
		(wall2 init: stopUpd:)
		(walls init: setOnMeCheck: 1 8)
		(floor init: setOnMeCheck: 1 32)
		(ceiling init: setOnMeCheck: 1 4)
		(trash init: setOnMeCheck: 1 2)
		(southExitFeature init:)
		(self setScript: sEnterElevator)
	)
	
	(method (doit)
		(cond 
			(script)
			((proc0_1 gEgo 16) (gEgo edgeHit: 3))
		)
		(super doit:)
	)
	
	(method (dispose)
		(DisposeScript 2660)
		(super dispose: &rest)
	)
	
	(method (notify)
		(if (== global123 5)
			(if (global2 script?)
				((global2 script?) next: sDie)
			else
				(global2 setScript: sDie)
			)
		)
	)
)

(instance sDie of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gWrapSound number: 3 flags: 1 loop: 1 play:)
				(gEgo setMotion: MoveTo 160 120 self)
			)
			(1
				(oriley
					init:
					setScale: 125
					setCycle: Walk
					setMotion: PChase gEgo 22 self
				)
			)
			(2
				(oriley view: 424)
				(oriley cel: 0)
				(proc0_5 gEgo oriley)
				(proc0_5 oriley gEgo)
				(= cycles 4)
			)
			(3 (oriley setCycle: End self))
			(4
				(thudSound play:)
				(gEgo view: 858 setCycle: End self)
			)
			(5
				(= global145 0)
				(global2 newRoom: 99)
				(self dispose:)
			)
		)
	)
)

(instance sGoingDown of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(switch state
			(5
				(gEgo
					scaleY: (+ (gEgo scaleY?) 2)
					scaleX: (- (gEgo scaleX?) 2)
				)
			)
			(6
				(gEgo
					scaleY: (- (gEgo scaleY?) 2)
					scaleX: (+ (gEgo scaleX?) 2)
				)
			)
			(10
				(gEgo
					scaleY: (- (gEgo scaleY?) 3)
					scaleX: (+ (gEgo scaleX?) 4)
				)
			)
			(11
				(gEgo
					scaleY: (+ (gEgo scaleY?) 3)
					scaleX: (- (gEgo scaleX?) 4)
				)
			)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 94 1) dispose: delete:)
				(gEgo setMotion: PolyPath 165 117 self)
			)
			(1
				(gEgo
					view: 661
					loop: 0
					cel: 0
					setScale: Scaler 100 100 0 10
					setCycle: CT 3 1 self
				)
			)
			(2
				(gEgo setCycle: End self)
				(crank setCycle: End self)
				(gGameMusic2 number: 661 flags: 1 loop: 1 play:)
			)
			(3
				(gWrapSound number: 660 flags: 1 loop: 1 play:)
			)
			(4
				(crank stopUpd:)
				(gEgo
					normalize: 426
					setScale: 125
					setHeading: 180
					scaleSignal: 1
					maxScale: 256
				)
				(gGameMusic2 number: 662 flags: 1 loop: -1 play:)
				(wall1 setCycle: Fwd)
				(wall2 setCycle: Fwd)
				(= cycles 1)
			)
			(5 (= cycles 10))
			(6 (= cycles 10))
			(7 (= seconds 2))
			(8
				(wall1 cycleSpeed: (+ (wall1 cycleSpeed?) 1))
				(wall2 cycleSpeed: (+ (wall1 cycleSpeed?) 1))
				(= seconds 1)
			)
			(9
				(if (< (wall1 cycleSpeed?) 8)
					(self changeState: 8)
				else
					(wall1 setCycle: End)
					(wall2 setCycle: End)
					(= cycles 1)
				)
			)
			(10 (= cycles 10))
			(11 (= cycles 10))
			(12
				(gGameMusic2 stop:)
				(gGame handsOn:)
				(wall1 stopUpd:)
				(wall2 stopUpd:)
				(global2 south: 700)
				(self dispose:)
			)
		)
	)
)

(instance sEnterElevator of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					posn: 160 200
					setHeading: 0
					setMotion: MoveFwd 80 self
				)
			)
			(1 (gEgo setHeading: 180 self))
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance oriley of Actor
	(properties
		x 160
		y 180
		view 423
	)
)

(instance crank of Prop
	(properties
		x 189
		y 80
		noun 1
		view 661
		loop 1
		priority 15
		signal $0010
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if local0
					(gLb2Messager say: 1 4 4)
				else
					(global2 setScript: sGoingDown)
					(= local0 1)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance wall1 of Prop
	(properties
		x 106
		y 125
		view 660
		cycleSpeed 0
	)
)

(instance wall2 of Prop
	(properties
		x 217
		y 125
		view 660
		cycleSpeed 0
	)
)

(instance walls of Feature
	(properties
		x 162
		y 8
		noun 2
	)
)

(instance floor of Feature
	(properties
		x 162
		y 8
		noun 5
	)
)

(instance ceiling of Feature
	(properties
		x 162
		y 8
		noun 4
	)
)

(instance trash of Feature
	(properties
		x 6
		y 60
		noun 3
		sightAngle 40
	)
)

(instance southExitFeature of ExitFeature
	(properties
		nsTop 122
		nsLeft 125
		nsBottom 189
		nsRight 202
		cursor 11
		exitDir 3
		noun 6
	)
)

(instance thudSound of Sound
	(properties
		flags $0001
		number 80
	)
)
